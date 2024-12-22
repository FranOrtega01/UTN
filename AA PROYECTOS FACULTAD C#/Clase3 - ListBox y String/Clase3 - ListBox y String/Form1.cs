using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Clase3___ListBox_y_String
{
    public partial class Screen1 : Form
    {
        public Screen1()
        {
            InitializeComponent();
        }

        private void btnAccept_Click(object sender, EventArgs e)
        {
            if (txtName.Text.Trim().Length > 0)
            {
                lbPeople.Items.Add(txtName.Text.Trim());
                txtName.Text = "";
            }
            else
            {
                MessageBox.Show("Debe escribir un nombre");
            }
        }

        private void btnSelected_Click(object sender, EventArgs e)
        {
            if (lbPeople.SelectedIndex != -1)
            {
                string names = "";
                foreach(string p in lbPeople.SelectedItems)
                {
                    names += p + " ";
                }
                MessageBox.Show(names.Trim());

            }
            else
            {
                MessageBox.Show("Seleccione un nombre");
            }

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Screen2 screen2 = new Screen2();
            this.Hide();
            screen2.Show();
        }
    }
}
