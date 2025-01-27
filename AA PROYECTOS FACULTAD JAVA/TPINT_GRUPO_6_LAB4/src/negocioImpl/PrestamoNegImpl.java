package negocioImpl;

import java.util.List;

import daoImpl.CuentaDaoImpl;
import daoImpl.PrestamoDaoImpl;
import entidad.Cuota;
import entidad.Prestamo;
import entidad.Respuesta;
import negocio.PrestamoNeg;

public class PrestamoNegImpl implements PrestamoNeg{
	
	private final int ESCALAR_DE_INTERES = 30; 
	
	private PrestamoDaoImpl preDao = new PrestamoDaoImpl();
	private CuentaDaoImpl cueDao = new CuentaDaoImpl();
	public boolean insert(Prestamo prestamo) {
		calcularMontoAPagar(prestamo);
		return preDao.insert(prestamo);
	}
    public boolean update(Prestamo prestamo) {
    	 if (!esEstadoValido(prestamo.getEstado())) {
             return false;
         }
		return preDao.update(prestamo);
    }
    public boolean delete(Prestamo prestamo) {
		return preDao.delete(prestamo);
    }
    public List<Prestamo> readAll(){
		List<Prestamo> prestamos = preDao.readAll();
		
        if (prestamos == null || prestamos.isEmpty()) {
            System.out.println("No hay prestamos disponibles.");
        } else {
            System.out.println("Prestamos encontrados: " + prestamos.size());
        }
        
        return prestamos;
    }
    
    public List<Prestamo> readByIDCuenta(int id){
		List<Prestamo> prestamos = preDao.readByIDCuenta(id);
		
        if (prestamos == null || prestamos.isEmpty()) {
            System.out.println("No hay prestamos disponibles.");
        } else {
            System.out.println("Prestamos encontrados: " + prestamos.size());
        }
        
        return prestamos;
    }
    
    public List<Prestamo> readByIDUser(int id){
		List<Prestamo> prestamos = preDao.readByIDUser(id);
		
        if (prestamos == null || prestamos.isEmpty()) {
            System.out.println("No hay prestamos disponibles.");
        } else {
            System.out.println("Prestamos encontrados: " + prestamos.size());
        }
        
        return prestamos;
    }
    
    public Respuesta pagarCuota(Cuota c) {
    	CuentaDaoImpl cueDao = new CuentaDaoImpl();
    	
    	Prestamo pre = preDao.readByPrestamoID(c.getIdPrestamo());
    	double saldo = cueDao.getCuentaByID(pre.getIdCuenta()).getSaldo();
    	
    	if(saldo < pre.getMontoMensual()) {
    		return new Respuesta(false, "Saldo insuficiente para abonar cuota");
    	}
    	
    	return preDao.pagarCuota(c);
    }
    
    
    private void calcularMontoAPagar(Prestamo prestamo) {
        double montoAPagar = prestamo.getImportePedido() * (1 + (double) prestamo.getPlazoPago() / ESCALAR_DE_INTERES);
        prestamo.setImporteAPagar(montoAPagar);
    }
    
    private boolean esEstadoValido(String estado) {
        return estado.equals("Pendiente") || estado.equals("Aprobado") || estado.equals("Rechazado") || estado.equals("Pagado");
    }
    
    public boolean existePrestamoActivo(int cuentaId) {
        return preDao.existePrestamoActivo(cuentaId);
    }
}
