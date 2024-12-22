using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace TP7._1
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void ListView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        protected void btnProvincias(object sender, CommandEventArgs e)
        {
            SqlDataSource2.SelectCommand = $"SELECT[Id_Sucursal], [NombreSucursal], [DescripcionSucursal], [Id_ProvinciaSucursal], [URL_Imagen_Sucursal] FROM[Sucursal] WHERE Id_ProvinciaSucursal = '{e.CommandArgument}' ";
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            SqlDataSource2.SelectCommand = $"SELECT[Id_Sucursal], [NombreSucursal], [DescripcionSucursal], [Id_ProvinciaSucursal], [URL_Imagen_Sucursal] FROM[Sucursal]" +
                $" WHERE NombreSucursal LIKE '%{TextBox1.Text}%' ";
        }
    }
}