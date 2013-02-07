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
            Protocol p = (Protocol)protocol.SelectedItem;
            try
            {
                EgoiApi api = EgoiApiFactory.getApi(Egoi.Protocol.XmlRpc);

                EgoiMap arguments = new EgoiMap();

                String apikey = "d7cdcc90c0547da5da90c3e14eeff180455c38a2";
                String listId = "2";

                // Struct do Subscriber 1
                EgoiMap subscriber1 = new EgoiMap();
                subscriber1.Add("email", "joaodelfino@gmail.com");
                subscriber1.Add("status", "4");

                // Struct do Subscriber 2
                EgoiMap subscriber2 = new EgoiMap();
                subscriber2.Add("email", "joao.delfino@hotmail.co.uk");
                subscriber2.Add("status", "4");

                // Struct do Subscriber 1
                EgoiMap subscriber3 = new EgoiMap();
                subscriber3.Add("email", "jp.delfino@clix.pt");
                subscriber3.Add("status", "0");

                // Lista de Subscribers
                EgoiMapList subscribers = new EgoiMapList();
                subscribers.Add(subscriber1);
                subscribers.Add(subscriber2);
                subscribers.Add(subscriber3);

                // Struct com os argumentos
                arguments.Add("apikey", apikey);
                arguments.Add("listID", listId);
                arguments.Add("compareField", "email");
                arguments.Add("subscribers", subscribers); // lista de subscribers

                EgoiMap result = api.addSubscriberBulk(arguments);
                output.Text = result.ToString();
            } catch(EgoiException ex) {
                status.Text = ex.Message;
            }
        }
    }
}
