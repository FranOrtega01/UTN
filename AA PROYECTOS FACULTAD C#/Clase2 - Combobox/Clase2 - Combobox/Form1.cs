using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Clase2___Combobox
{
    public partial class Form1 : Form
    {
        public Form1() 
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            cbColor.Items.Add("Azul");
            cbColor.Items.Add("Amarillo");
            cbColor.Items.Add("Rojo");
            cbColor.Items.Add("Verde");
            cbColor.Items.Add("Violeta");

        }

        private void btnAccept_Click(object sender, EventArgs e)
        {
            if (cbColor.SelectedIndex != -1)
            {
                MessageBox.Show("Color: " + cbColor.SelectedItem +
                    " - Posicion: " + cbColor.SelectedIndex);
            }
        }
    }
}
