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
            outputGetUserData.Clear();
            Protocol p = (Protocol) protocol.SelectedItem;
            try
            {
                EgoiApi api = EgoiApiFactory.getApi(p);
                EgoiMap arguments = new EgoiMap();
                arguments.Add("apikey", apiKey.Text);
                EgoiMap result = api.getUserData(arguments);
                outputGetUserData.Text = result.ToString();
            } catch(EgoiException ex) {
                status.Text = ex.Message;
            }   
        }

        private void processCallTag_Click(object sender, EventArgs e)
        {
            status.Text = "";
            outputGetTag.Clear();
            Protocol p = (Protocol)protocol.SelectedItem;
            try
            {
                EgoiApi api = EgoiApiFactory.getApi(p);
                EgoiMap arguments = new EgoiMap();
                arguments.Add("apikey", apiKey.Text);
                EgoiMapList result = api.getTags(arguments);
                outputGetTag.Text = result.ToString();
            }
            catch (EgoiException ex)
            {
                status.Text = ex.Message;
            }
        }

        private void setTagColor_Click(object sender, EventArgs e)
        {
             colorDialog1.Color = setTagColor.ForeColor;

            if(colorDialog1.ShowDialog() == DialogResult.OK)
            {
                setTagColor.ForeColor = colorDialog1.Color;
                setTagColor.Text = HexColorConverter(colorDialog1.Color);
            }
        }

        private string HexColorConverter(Color c)
        {
            return "#" + c.R.ToString("X2") + c.G.ToString("X2") + c.B.ToString("X2");
        }

        private void processCallAddTag_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(textBoxTagName.Text))
            {
                MessageBox.Show("You must set a name for the new Tag");
                return;
            }

            status.Text = "";
            outputAddTag.Clear();
            Protocol p = (Protocol)protocol.SelectedItem;
            try
            {
                EgoiApi api = EgoiApiFactory.getApi(p);
                EgoiMap arguments = new EgoiMap();
                arguments.Add("apikey", apiKey.Text);
                arguments.Add("name", textBoxTagName.Text);

                if (!string.IsNullOrEmpty(setTagColor.Text))
                {
                    arguments.Add("color", setTagColor.Text);
                }

                EgoiMap result = api.addTag(arguments);
                outputAddTag.Text = result.ToString();
            }
            catch (EgoiException ex)
            {
                status.Text = ex.Message;
            }
        }

        private void processCallAttachTag_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(textBoxAttachTagTagNumber.Text))
            {
                MessageBox.Show("You must set the tag number first...");
                return;
            }

            if (listBoxAttachTagTarget.Items.Count < 1)
            {
                MessageBox.Show("You must set at least a target...");
                return;
            }

            if (string.IsNullOrEmpty(textBoxAttachTagListId.Text))
            {
                MessageBox.Show("You must set the list id...");
                return;
            }

            status.Text = "";
            outputAttachTag.Clear();
            Protocol p = (Protocol)protocol.SelectedItem;
            try
            {
                EgoiApi api = EgoiApiFactory.getApi(p);
                EgoiMap arguments = new EgoiMap();
                arguments.Add("apikey", apiKey.Text);
                arguments.Add("tag", textBoxAttachTagTagNumber.Text);

                EgoiMap em = new EgoiMap();

                foreach(var subscriber in new System.Collections.ArrayList(listBoxAttachTagTarget.Items))
                {
                    em.Add("subscriber", subscriber);
                }
                
                arguments.Add("target", em);

                arguments.Add("type", "subscriber"); //for now is the only one. Meanwhile, we have to put it here. It's required.

                arguments.Add("listID", textBoxAttachTagListId.Text);

                EgoiMap result = api.attachTag(arguments);
                outputAttachTag.Text = result.ToString();
            }
            catch (EgoiException ex)
            {
                status.Text = ex.Message;
            }
        }

        private void buttonAttachTagAdd_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(textBoxAttachTagTarget.Text))
            {
                MessageBox.Show("You should write the Target...");
                return;
            }

            listBoxAttachTagTarget.Items.Add(textBoxAttachTagTarget.Text);

            textBoxAttachTagTarget.Text = "";
        }

        private void buttonAttachTagRemove_Click(object sender, EventArgs e)
        {
            int i = listBoxAttachTagTarget.SelectedIndex;

            if (i < 0)
            {
                MessageBox.Show("You should first select a row to delete.");
                return;
            }

            listBoxAttachTagTarget.Items.RemoveAt(i);
        }

        private void buttonAddSubscriberAddTag_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(textBoxAddSubscriberTagId.Text))
            {
                MessageBox.Show("You should write the Tag ID...");
                return;
            }

            listBoxAddSubscriberTagId.Items.Add(textBoxAddSubscriberTagId.Text);

            textBoxAddSubscriberTagId.Text = "";
        }

        private void buttonAddSubscriberRemoveTag_Click(object sender, EventArgs e)
        {
            int i = listBoxAddSubscriberTagId.SelectedIndex;

            if (i < 0)
            {
                MessageBox.Show("You should first select a row to delete.");
                return;
            }

            listBoxAddSubscriberTagId.Items.RemoveAt(i);
        }

        private void buttonAddSubscriber_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(textBoxAddSubscriberListID.Text))
            {
                MessageBox.Show("You must set the list id first...");
                return;
            }

            status.Text = "";
            outputAddSubscriber.Clear();
            Protocol p = (Protocol)protocol.SelectedItem;
            try
            {
                EgoiApi api = EgoiApiFactory.getApi(p);
                EgoiMap arguments = new EgoiMap();
                arguments.Add("apikey", apiKey.Text);
                arguments.Add("listID", textBoxAddSubscriberListID.Text);
                arguments.Add("subscriber", textBoxAddSubscriberSubscriber.Text);
                arguments.Add("status", comboBoxAddSubscriberStatus.Text);
                arguments.Add("from", textBoxAddSubscriberFrom.Text);
                arguments.Add("lang", comboBoxAddSubscriberLang.Text);
                arguments.Add("email", textBoxAddSubscriberEmail.Text);
                arguments.Add("validate_phone", comboBoxAddSubscriberValidatePhone.Text);
                arguments.Add("cellphone", textBoxAddSubscriberCellphone.Text);
                arguments.Add("telephone", textBoxAddSubscriberTelephone.Text);
                arguments.Add("fax", textBoxAddSubscriberFax.Text);
                arguments.Add("first_name", textBoxAddSubscriberFirstName.Text);
                arguments.Add("last_name", textBoxAddSubscriberLastName.Text);
                arguments.Add("birth_date", dateTimePickerAddSubscriberBirthDate.Text);

                //example on how to use extra fields
                //arguments.Add("extra_1", "value for extra_1");
                //arguments.Add("extra_2", "value for extra_2");
                //arguments.Add("extra_3", "value for extra_3");
                //and so on...


                EgoiMap em = new EgoiMap();

                foreach (var tag in new System.Collections.ArrayList(listBoxAddSubscriberTagId.Items))
                {
                    em.Add("id", tag);
                }

                arguments.Add("tags", em);

                arguments.Add("formID", textBoxAddSubscriberFormId.Text);

                EgoiMap result = api.addSubscriber(arguments);
                outputAddSubscriber.Text = result.ToString();
            }
            catch (EgoiException ex)
            {
                status.Text = ex.Message;
            }
        }
    }
}
