
namespace Clase3___ListBox_y_String
{
    partial class Screen1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblName = new System.Windows.Forms.Label();
            this.txtName = new System.Windows.Forms.TextBox();
            this.btnAccept = new System.Windows.Forms.Button();
            this.lbPeople = new System.Windows.Forms.ListBox();
            this.btnSelected = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lblName
            // 
            this.lblName.AutoSize = true;
            this.lblName.Location = new System.Drawing.Point(47, 13);
            this.lblName.Name = "lblName";
            this.lblName.Size = new System.Drawing.Size(91, 13);
            this.lblName.TabIndex = 0;
            this.lblName.Text = "Ingrese nombres: ";
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(50, 29);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(158, 20);
            this.txtName.TabIndex = 1;
            // 
            // btnAccept
            // 
            this.btnAccept.Location = new System.Drawing.Point(227, 13);
            this.btnAccept.Name = "btnAccept";
            this.btnAccept.Size = new System.Drawing.Size(126, 36);
            this.btnAccept.TabIndex = 2;
            this.btnAccept.Text = "Agregar";
            this.btnAccept.UseVisualStyleBackColor = true;
            this.btnAccept.Click += new System.EventHandler(this.btnAccept_Click);
            // 
            // lbPeople
            // 
            this.lbPeople.FormattingEnabled = true;
            this.lbPeople.Location = new System.Drawing.Point(50, 76);
            this.lbPeople.Name = "lbPeople";
            this.lbPeople.SelectionMode = System.Windows.Forms.SelectionMode.MultiExtended;
            this.lbPeople.Size = new System.Drawing.Size(158, 95);
            this.lbPeople.TabIndex = 3;
            // 
            // btnSelected
            // 
            this.btnSelected.Location = new System.Drawing.Point(227, 76);
            this.btnSelected.Name = "btnSelected";
            this.btnSelected.Size = new System.Drawing.Size(126, 23);
            this.btnSelected.TabIndex = 4;
            this.btnSelected.Text = "Mostrar Seleccion";
            this.btnSelected.UseVisualStyleBackColor = true;
            this.btnSelected.Click += new System.EventHandler(this.btnSelected_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(50, 225);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(199, 42);
            this.button1.TabIndex = 5;
            this.button1.Text = "Ir a Screen 2";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Screen1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(629, 443);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.btnSelected);
            this.Controls.Add(this.lbPeople);
            this.Controls.Add(this.btnAccept);
            this.Controls.Add(this.txtName);
            this.Controls.Add(this.lblName);
            this.Name = "Screen1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblName;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.Button btnAccept;
        private System.Windows.Forms.ListBox lbPeople;
        private System.Windows.Forms.Button btnSelected;
        private System.Windows.Forms.Button button1;
    }
}

