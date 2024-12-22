using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication2
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void BtnTable_Click(object sender, EventArgs e)
        {
            if(txtProd1.Text == "" || txtProd2.Text == "" || txtQty1.Text == "" || txtQty2.Text == "")
            {
                lblAlert.Text = "Debe llenar todos los espacios.";
                return;
            }

            if (!int.TryParse(txtQty1.Text, out int num1) || !int.TryParse(txtQty2.Text, out int num2))
            {
                lblAlert.Text = "Solo se aceptan numeros como cantidad.";
                return;
            }

            lblAlert.Text = "";
            string table = "<table border='1'>";
            table += "<tr> <td>Producto</td> <td>Cantidad</td> </tr>";
            table += $"<tr> <td>{txtProd1.Text}</td> <td>{txtQty1.Text}</td> </tr>";
            table += $"<tr> <td>{txtProd2.Text}</td> <td>{txtQty2.Text}</td> </tr>";
            table += $"<tr> <td>TOTAL</td> <td>{Convert.ToInt32(txtQty1.Text) + Convert.ToInt32(txtQty2.Text)}</td> </tr>";
            table += "</table>";

            lblTable.Text = table;
        }
    }
}