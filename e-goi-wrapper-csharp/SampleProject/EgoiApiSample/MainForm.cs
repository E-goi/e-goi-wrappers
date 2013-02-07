using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Egoi;

namespace EgoiSample
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();


            var protocols = Enum.GetValues(typeof(Protocol));
            foreach (var p in protocols)
                protocol.Items.Add(p);
            protocol.SelectedIndex = 0;
        }

        private void processCall_Click(object sender, EventArgs e)
        {
            status.Text = "";
            output.Clear();
            Protocol p = (Protocol) protocol.SelectedItem;
            try
            {
                EgoiApi api = EgoiApiFactory.getApi(p);
                EgoiMap arguments = new EgoiMap();
                arguments.Add("apikey", apiKey.Text);
                EgoiMap result = api.getUserData(arguments);
                output.Text = result.ToString();
            } catch(EgoiException ex) {
                status.Text = ex.Message;
            }   
        }
    }
}
