namespace EgoiSample
{
    partial class MainForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.apiKeyLabel = new System.Windows.Forms.Label();
            this.apiKey = new System.Windows.Forms.TextBox();
            this.processCall = new System.Windows.Forms.Button();
            this.protocol = new System.Windows.Forms.ComboBox();
            this.protocolLabel = new System.Windows.Forms.Label();
            this.output = new System.Windows.Forms.RichTextBox();
            this.statusLabel = new System.Windows.Forms.Label();
            this.status = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // apiKeyLabel
            // 
            this.apiKeyLabel.AutoSize = true;
            this.apiKeyLabel.Location = new System.Drawing.Point(14, 16);
            this.apiKeyLabel.Name = "apiKeyLabel";
            this.apiKeyLabel.Size = new System.Drawing.Size(43, 13);
            this.apiKeyLabel.TabIndex = 0;
            this.apiKeyLabel.Text = "Api Key";
            // 
            // apiKey
            // 
            this.apiKey.Location = new System.Drawing.Point(63, 13);
            this.apiKey.Name = "apiKey";
            this.apiKey.Size = new System.Drawing.Size(398, 20);
            this.apiKey.TabIndex = 1;
            // 
            // processCall
            // 
            this.processCall.Location = new System.Drawing.Point(314, 40);
            this.processCall.Name = "processCall";
            this.processCall.Size = new System.Drawing.Size(147, 23);
            this.processCall.TabIndex = 2;
            this.processCall.Text = "EgoiApi.getUserData()";
            this.processCall.UseVisualStyleBackColor = true;
            this.processCall.Click += new System.EventHandler(this.processCall_Click);
            // 
            // protocol
            // 
            this.protocol.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.protocol.FormattingEnabled = true;
            this.protocol.Location = new System.Drawing.Point(187, 42);
            this.protocol.Name = "protocol";
            this.protocol.Size = new System.Drawing.Size(121, 21);
            this.protocol.TabIndex = 3;
            // 
            // protocolLabel
            // 
            this.protocolLabel.AutoSize = true;
            this.protocolLabel.Location = new System.Drawing.Point(135, 45);
            this.protocolLabel.Name = "protocolLabel";
            this.protocolLabel.Size = new System.Drawing.Size(46, 13);
            this.protocolLabel.TabIndex = 4;
            this.protocolLabel.Text = "Protocol";
            // 
            // output
            // 
            this.output.Location = new System.Drawing.Point(13, 69);
            this.output.Name = "output";
            this.output.Size = new System.Drawing.Size(448, 309);
            this.output.TabIndex = 5;
            this.output.Text = "";
            // 
            // statusLabel
            // 
            this.statusLabel.AutoSize = true;
            this.statusLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.statusLabel.Location = new System.Drawing.Point(14, 381);
            this.statusLabel.Name = "statusLabel";
            this.statusLabel.Size = new System.Drawing.Size(47, 13);
            this.statusLabel.TabIndex = 6;
            this.statusLabel.Text = "Status:";
            // 
            // status
            // 
            this.status.Location = new System.Drawing.Point(68, 381);
            this.status.Name = "status";
            this.status.Size = new System.Drawing.Size(393, 13);
            this.status.TabIndex = 7;
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(473, 403);
            this.Controls.Add(this.status);
            this.Controls.Add(this.statusLabel);
            this.Controls.Add(this.output);
            this.Controls.Add(this.protocolLabel);
            this.Controls.Add(this.protocol);
            this.Controls.Add(this.processCall);
            this.Controls.Add(this.apiKey);
            this.Controls.Add(this.apiKeyLabel);
            this.Name = "MainForm";
            this.Text = "Egoi Api Sample";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label apiKeyLabel;
        private System.Windows.Forms.TextBox apiKey;
        private System.Windows.Forms.Button processCall;
        private System.Windows.Forms.ComboBox protocol;
        private System.Windows.Forms.Label protocolLabel;
        private System.Windows.Forms.RichTextBox output;
        private System.Windows.Forms.Label statusLabel;
        private System.Windows.Forms.Label status;
    }
}

