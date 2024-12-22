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
    public partial class Screen2 : Form
    {
        public Screen2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Screen1 screen1 = new Screen1();
            this.Hide();
            screen1.Show();
        }
    }
}
