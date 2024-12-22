using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication2
{
    public partial class WebForm2b : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string name = Request["txtName"].ToString();
            string surname = Request["txtSurname"].ToString();
            string city = ((DropDownList)PreviousPage.FindControl("ddlCity")).SelectedValue;
            CheckBoxList cblItems = (CheckBoxList)PreviousPage.FindControl("cblTemas");

            txtName.Text = name;
            txtSurname.Text = surname;
            txtCity.Text = city;

            foreach (ListItem item in cblItems.Items)
            {
                if (item.Selected)
                {
                    txtTemas.Text += item.Text + "<br />";
                }
            }
        }
    }
}