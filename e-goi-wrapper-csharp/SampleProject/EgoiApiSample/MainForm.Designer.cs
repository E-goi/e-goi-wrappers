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
            this.processCallUserData = new System.Windows.Forms.Button();
            this.protocol = new System.Windows.Forms.ComboBox();
            this.protocolLabel = new System.Windows.Forms.Label();
            this.outputGetUserData = new System.Windows.Forms.RichTextBox();
            this.statusLabel = new System.Windows.Forms.Label();
            this.status = new System.Windows.Forms.Label();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.tabControl2 = new System.Windows.Forms.TabControl();
            this.tabPage4 = new System.Windows.Forms.TabPage();
            this.tabControl3 = new System.Windows.Forms.TabControl();
            this.tabPage3 = new System.Windows.Forms.TabPage();
            this.tabPage5 = new System.Windows.Forms.TabPage();
            this.processCallTag = new System.Windows.Forms.Button();
            this.outputGetTag = new System.Windows.Forms.RichTextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.textBoxTagName = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.colorDialog1 = new System.Windows.Forms.ColorDialog();
            this.setTagColor = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.processCallAddTag = new System.Windows.Forms.Button();
            this.outputAddTag = new System.Windows.Forms.RichTextBox();
            this.tabPage6 = new System.Windows.Forms.TabPage();
            this.processCallAttachTag = new System.Windows.Forms.Button();
            this.outputAttachTag = new System.Windows.Forms.RichTextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.textBoxAttachTagTagNumber = new System.Windows.Forms.TextBox();
            this.textBoxAttachTagTarget = new System.Windows.Forms.TextBox();
            this.buttonAttachTagAdd = new System.Windows.Forms.Button();
            this.listBoxAttachTagTarget = new System.Windows.Forms.ListBox();
            this.buttonAttachTagRemove = new System.Windows.Forms.Button();
            this.label6 = new System.Windows.Forms.Label();
            this.textBoxAttachTagListId = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.tabControl1.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.tabControl2.SuspendLayout();
            this.tabPage4.SuspendLayout();
            this.tabControl3.SuspendLayout();
            this.tabPage3.SuspendLayout();
            this.tabPage5.SuspendLayout();
            this.tabPage6.SuspendLayout();
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
            this.apiKey.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.apiKey.Location = new System.Drawing.Point(63, 13);
            this.apiKey.Name = "apiKey";
            this.apiKey.Size = new System.Drawing.Size(493, 20);
            this.apiKey.TabIndex = 1;
            // 
            // processCallUserData
            // 
            this.processCallUserData.Location = new System.Drawing.Point(6, 6);
            this.processCallUserData.Name = "processCallUserData";
            this.processCallUserData.Size = new System.Drawing.Size(147, 23);
            this.processCallUserData.TabIndex = 2;
            this.processCallUserData.Text = "EgoiApi.getUserData()";
            this.processCallUserData.UseVisualStyleBackColor = true;
            this.processCallUserData.Click += new System.EventHandler(this.processCall_Click);
            // 
            // protocol
            // 
            this.protocol.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.protocol.FormattingEnabled = true;
            this.protocol.Location = new System.Drawing.Point(63, 39);
            this.protocol.Name = "protocol";
            this.protocol.Size = new System.Drawing.Size(121, 21);
            this.protocol.TabIndex = 3;
            // 
            // protocolLabel
            // 
            this.protocolLabel.AutoSize = true;
            this.protocolLabel.Location = new System.Drawing.Point(11, 42);
            this.protocolLabel.Name = "protocolLabel";
            this.protocolLabel.Size = new System.Drawing.Size(46, 13);
            this.protocolLabel.TabIndex = 4;
            this.protocolLabel.Text = "Protocol";
            // 
            // outputGetUserData
            // 
            this.outputGetUserData.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.outputGetUserData.Location = new System.Drawing.Point(6, 35);
            this.outputGetUserData.Name = "outputGetUserData";
            this.outputGetUserData.Size = new System.Drawing.Size(510, 210);
            this.outputGetUserData.TabIndex = 5;
            this.outputGetUserData.Text = "";
            // 
            // statusLabel
            // 
            this.statusLabel.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.statusLabel.AutoSize = true;
            this.statusLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.statusLabel.Location = new System.Drawing.Point(9, 354);
            this.statusLabel.Name = "statusLabel";
            this.statusLabel.Size = new System.Drawing.Size(47, 13);
            this.statusLabel.TabIndex = 6;
            this.statusLabel.Text = "Status:";
            // 
            // status
            // 
            this.status.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.status.AutoSize = true;
            this.status.Location = new System.Drawing.Point(62, 354);
            this.status.Name = "status";
            this.status.Size = new System.Drawing.Size(0, 13);
            this.status.TabIndex = 7;
            // 
            // tabControl1
            // 
            this.tabControl1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Location = new System.Drawing.Point(12, 69);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(544, 282);
            this.tabControl1.TabIndex = 8;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.tabControl2);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(536, 283);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "UserData";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.tabControl3);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(536, 256);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "TAG";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // tabControl2
            // 
            this.tabControl2.Controls.Add(this.tabPage4);
            this.tabControl2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tabControl2.Location = new System.Drawing.Point(3, 3);
            this.tabControl2.Name = "tabControl2";
            this.tabControl2.SelectedIndex = 0;
            this.tabControl2.Size = new System.Drawing.Size(530, 277);
            this.tabControl2.TabIndex = 0;
            // 
            // tabPage4
            // 
            this.tabPage4.Controls.Add(this.processCallUserData);
            this.tabPage4.Controls.Add(this.outputGetUserData);
            this.tabPage4.Location = new System.Drawing.Point(4, 22);
            this.tabPage4.Name = "tabPage4";
            this.tabPage4.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage4.Size = new System.Drawing.Size(522, 251);
            this.tabPage4.TabIndex = 1;
            this.tabPage4.Text = "Get";
            this.tabPage4.UseVisualStyleBackColor = true;
            // 
            // tabControl3
            // 
            this.tabControl3.Controls.Add(this.tabPage3);
            this.tabControl3.Controls.Add(this.tabPage5);
            this.tabControl3.Controls.Add(this.tabPage6);
            this.tabControl3.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tabControl3.Location = new System.Drawing.Point(3, 3);
            this.tabControl3.Name = "tabControl3";
            this.tabControl3.SelectedIndex = 0;
            this.tabControl3.Size = new System.Drawing.Size(530, 250);
            this.tabControl3.TabIndex = 0;
            // 
            // tabPage3
            // 
            this.tabPage3.Controls.Add(this.outputGetTag);
            this.tabPage3.Controls.Add(this.processCallTag);
            this.tabPage3.Location = new System.Drawing.Point(4, 22);
            this.tabPage3.Name = "tabPage3";
            this.tabPage3.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage3.Size = new System.Drawing.Size(522, 224);
            this.tabPage3.TabIndex = 0;
            this.tabPage3.Text = "GET";
            this.tabPage3.UseVisualStyleBackColor = true;
            // 
            // tabPage5
            // 
            this.tabPage5.Controls.Add(this.outputAddTag);
            this.tabPage5.Controls.Add(this.processCallAddTag);
            this.tabPage5.Controls.Add(this.label3);
            this.tabPage5.Controls.Add(this.setTagColor);
            this.tabPage5.Controls.Add(this.label2);
            this.tabPage5.Controls.Add(this.textBoxTagName);
            this.tabPage5.Controls.Add(this.label1);
            this.tabPage5.Location = new System.Drawing.Point(4, 22);
            this.tabPage5.Name = "tabPage5";
            this.tabPage5.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage5.Size = new System.Drawing.Size(522, 224);
            this.tabPage5.TabIndex = 1;
            this.tabPage5.Text = "ADD";
            this.tabPage5.UseVisualStyleBackColor = true;
            // 
            // processCallTag
            // 
            this.processCallTag.Location = new System.Drawing.Point(6, 6);
            this.processCallTag.Name = "processCallTag";
            this.processCallTag.Size = new System.Drawing.Size(147, 23);
            this.processCallTag.TabIndex = 3;
            this.processCallTag.Text = "EgoiApi.getTags()";
            this.processCallTag.UseVisualStyleBackColor = true;
            this.processCallTag.Click += new System.EventHandler(this.processCallTag_Click);
            // 
            // outputGetTag
            // 
            this.outputGetTag.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.outputGetTag.Location = new System.Drawing.Point(6, 35);
            this.outputGetTag.Name = "outputGetTag";
            this.outputGetTag.Size = new System.Drawing.Size(510, 183);
            this.outputGetTag.TabIndex = 6;
            this.outputGetTag.Text = "";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(21, 20);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(48, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Name(*):";
            // 
            // textBoxTagName
            // 
            this.textBoxTagName.Location = new System.Drawing.Point(75, 17);
            this.textBoxTagName.Name = "textBoxTagName";
            this.textBoxTagName.Size = new System.Drawing.Size(100, 20);
            this.textBoxTagName.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(35, 53);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(34, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Color:";
            // 
            // setTagColor
            // 
            this.setTagColor.Location = new System.Drawing.Point(75, 48);
            this.setTagColor.Name = "setTagColor";
            this.setTagColor.Size = new System.Drawing.Size(100, 23);
            this.setTagColor.TabIndex = 3;
            this.setTagColor.UseVisualStyleBackColor = true;
            this.setTagColor.Click += new System.EventHandler(this.setTagColor_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(261, 20);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(63, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "(*) Required";
            // 
            // processCallAddTag
            // 
            this.processCallAddTag.Location = new System.Drawing.Point(24, 96);
            this.processCallAddTag.Name = "processCallAddTag";
            this.processCallAddTag.Size = new System.Drawing.Size(151, 23);
            this.processCallAddTag.TabIndex = 5;
            this.processCallAddTag.Text = "EgoiApi.addTags()";
            this.processCallAddTag.UseVisualStyleBackColor = true;
            this.processCallAddTag.Click += new System.EventHandler(this.processCallAddTag_Click);
            // 
            // outputAddTag
            // 
            this.outputAddTag.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.outputAddTag.Location = new System.Drawing.Point(6, 125);
            this.outputAddTag.Name = "outputAddTag";
            this.outputAddTag.Size = new System.Drawing.Size(510, 93);
            this.outputAddTag.TabIndex = 7;
            this.outputAddTag.Text = "";
            // 
            // tabPage6
            // 
            this.tabPage6.Controls.Add(this.label8);
            this.tabPage6.Controls.Add(this.label7);
            this.tabPage6.Controls.Add(this.textBoxAttachTagListId);
            this.tabPage6.Controls.Add(this.label6);
            this.tabPage6.Controls.Add(this.buttonAttachTagRemove);
            this.tabPage6.Controls.Add(this.listBoxAttachTagTarget);
            this.tabPage6.Controls.Add(this.buttonAttachTagAdd);
            this.tabPage6.Controls.Add(this.textBoxAttachTagTarget);
            this.tabPage6.Controls.Add(this.textBoxAttachTagTagNumber);
            this.tabPage6.Controls.Add(this.label5);
            this.tabPage6.Controls.Add(this.label4);
            this.tabPage6.Controls.Add(this.outputAttachTag);
            this.tabPage6.Controls.Add(this.processCallAttachTag);
            this.tabPage6.Location = new System.Drawing.Point(4, 22);
            this.tabPage6.Name = "tabPage6";
            this.tabPage6.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage6.Size = new System.Drawing.Size(522, 224);
            this.tabPage6.TabIndex = 2;
            this.tabPage6.Text = "ATTACH";
            this.tabPage6.UseVisualStyleBackColor = true;
            // 
            // processCallAttachTag
            // 
            this.processCallAttachTag.Location = new System.Drawing.Point(6, 195);
            this.processCallAttachTag.Name = "processCallAttachTag";
            this.processCallAttachTag.Size = new System.Drawing.Size(188, 23);
            this.processCallAttachTag.TabIndex = 6;
            this.processCallAttachTag.Text = "EgoiApi.attachTags()";
            this.processCallAttachTag.UseVisualStyleBackColor = true;
            this.processCallAttachTag.Click += new System.EventHandler(this.processCallAttachTag_Click);
            // 
            // outputAttachTag
            // 
            this.outputAttachTag.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.outputAttachTag.Location = new System.Drawing.Point(276, 62);
            this.outputAttachTag.Name = "outputAttachTag";
            this.outputAttachTag.Size = new System.Drawing.Size(240, 156);
            this.outputAttachTag.TabIndex = 8;
            this.outputAttachTag.Text = "";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(6, 12);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(82, 13);
            this.label4.TabIndex = 9;
            this.label4.Text = "Tag Number (*):";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(6, 36);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(69, 13);
            this.label5.TabIndex = 10;
            this.label5.Text = "Target (*) (1):";
            // 
            // textBoxAttachTagTagNumber
            // 
            this.textBoxAttachTagTagNumber.Location = new System.Drawing.Point(94, 9);
            this.textBoxAttachTagTagNumber.Name = "textBoxAttachTagTagNumber";
            this.textBoxAttachTagTagNumber.Size = new System.Drawing.Size(100, 20);
            this.textBoxAttachTagTagNumber.TabIndex = 11;
            // 
            // textBoxAttachTagTarget
            // 
            this.textBoxAttachTagTarget.Location = new System.Drawing.Point(94, 36);
            this.textBoxAttachTagTarget.Name = "textBoxAttachTagTarget";
            this.textBoxAttachTagTarget.Size = new System.Drawing.Size(100, 20);
            this.textBoxAttachTagTarget.TabIndex = 12;
            // 
            // buttonAttachTagAdd
            // 
            this.buttonAttachTagAdd.Location = new System.Drawing.Point(200, 34);
            this.buttonAttachTagAdd.Name = "buttonAttachTagAdd";
            this.buttonAttachTagAdd.Size = new System.Drawing.Size(75, 23);
            this.buttonAttachTagAdd.TabIndex = 13;
            this.buttonAttachTagAdd.Text = "Add Target";
            this.buttonAttachTagAdd.UseVisualStyleBackColor = true;
            this.buttonAttachTagAdd.Click += new System.EventHandler(this.buttonAttachTagAdd_Click);
            // 
            // listBoxAttachTagTarget
            // 
            this.listBoxAttachTagTarget.FormattingEnabled = true;
            this.listBoxAttachTagTarget.Location = new System.Drawing.Point(6, 62);
            this.listBoxAttachTagTarget.Name = "listBoxAttachTagTarget";
            this.listBoxAttachTagTarget.Size = new System.Drawing.Size(188, 69);
            this.listBoxAttachTagTarget.TabIndex = 14;
            // 
            // buttonAttachTagRemove
            // 
            this.buttonAttachTagRemove.Location = new System.Drawing.Point(6, 137);
            this.buttonAttachTagRemove.Name = "buttonAttachTagRemove";
            this.buttonAttachTagRemove.Size = new System.Drawing.Size(188, 23);
            this.buttonAttachTagRemove.TabIndex = 15;
            this.buttonAttachTagRemove.Text = "Remove";
            this.buttonAttachTagRemove.UseVisualStyleBackColor = true;
            this.buttonAttachTagRemove.Click += new System.EventHandler(this.buttonAttachTagRemove_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(6, 172);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(50, 13);
            this.label6.TabIndex = 16;
            this.label6.Text = "ListID (*):";
            // 
            // textBoxAttachTagListId
            // 
            this.textBoxAttachTagListId.Location = new System.Drawing.Point(94, 169);
            this.textBoxAttachTagListId.Name = "textBoxAttachTagListId";
            this.textBoxAttachTagListId.Size = new System.Drawing.Size(100, 20);
            this.textBoxAttachTagListId.TabIndex = 17;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(282, 3);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(63, 13);
            this.label7.TabIndex = 18;
            this.label7.Text = "(*) Required";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(282, 34);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(163, 13);
            this.label8.TabIndex = 19;
            this.label8.Text = "(1) You can add the subscriber id";
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(568, 403);
            this.Controls.Add(this.tabControl1);
            this.Controls.Add(this.status);
            this.Controls.Add(this.statusLabel);
            this.Controls.Add(this.protocolLabel);
            this.Controls.Add(this.protocol);
            this.Controls.Add(this.apiKey);
            this.Controls.Add(this.apiKeyLabel);
            this.Name = "MainForm";
            this.Text = "Egoi Api Sample";
            this.tabControl1.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage2.ResumeLayout(false);
            this.tabControl2.ResumeLayout(false);
            this.tabPage4.ResumeLayout(false);
            this.tabControl3.ResumeLayout(false);
            this.tabPage3.ResumeLayout(false);
            this.tabPage5.ResumeLayout(false);
            this.tabPage5.PerformLayout();
            this.tabPage6.ResumeLayout(false);
            this.tabPage6.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label apiKeyLabel;
        private System.Windows.Forms.TextBox apiKey;
        private System.Windows.Forms.Button processCallUserData;
        private System.Windows.Forms.ComboBox protocol;
        private System.Windows.Forms.Label protocolLabel;
        private System.Windows.Forms.RichTextBox outputGetUserData;
        private System.Windows.Forms.Label statusLabel;
        private System.Windows.Forms.Label status;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabControl tabControl2;
        private System.Windows.Forms.TabPage tabPage4;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.TabControl tabControl3;
        private System.Windows.Forms.TabPage tabPage3;
        private System.Windows.Forms.Button processCallTag;
        private System.Windows.Forms.TabPage tabPage5;
        private System.Windows.Forms.RichTextBox outputGetTag;
        private System.Windows.Forms.Button processCallAddTag;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button setTagColor;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textBoxTagName;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ColorDialog colorDialog1;
        private System.Windows.Forms.RichTextBox outputAddTag;
        private System.Windows.Forms.TabPage tabPage6;
        private System.Windows.Forms.Button processCallAttachTag;
        private System.Windows.Forms.RichTextBox outputAttachTag;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox textBoxAttachTagListId;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button buttonAttachTagRemove;
        private System.Windows.Forms.ListBox listBoxAttachTagTarget;
        private System.Windows.Forms.Button buttonAttachTagAdd;
        private System.Windows.Forms.TextBox textBoxAttachTagTarget;
        private System.Windows.Forms.TextBox textBoxAttachTagTagNumber;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
    }
}

