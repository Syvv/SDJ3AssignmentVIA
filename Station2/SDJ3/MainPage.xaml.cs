using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;
using System.Net.Sockets;
using System.Net;

namespace SDJ3
{
    public sealed partial class MainPage : Page
    {
        TcpClient c;
        NetworkStream nws;
        IPAddress address = IPAddress.Parse("127.0.0.1");
        int port = 9999;
        Byte[] Data;

        public MainPage()
        {
            this.InitializeComponent();

            c = new TcpClient();
            c.ConnectAsync(address, port);
            if(c.Connected)
            {
                nws = c.GetStream();
                ConnectionText.Text = "Connected to the server";
            }
            else
            {
                ConnectionText.Text = "NOT CONNECTED TO THE SERVER";
            }
            
            
        }

        private void SendData(string message)
        {
            Data = System.Text.Encoding.ASCII.GetBytes(message);
            nws.Write(Data, 0, Data.Length);            
        }
    
        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {

        }

        private void Submit_Click(object sender, RoutedEventArgs e)
        {
            SendData(ChassisNr.Text + "*" + Weight.Text + "*" + PartNr.Text + "*" + PartDesc.Text);
        }

        private void Grid_Unloaded(object sender, RoutedEventArgs e) => c.Dispose();

        private void ReconnectButton_Click(object sender, RoutedEventArgs e)
        {
            c.Dispose();
            c = new TcpClient();
            c.ConnectAsync(address, port);
            if (c.Connected)
            {
                nws = c.GetStream();
                ConnectionText.Text = "Connected to the server";
            }
            else
            {
                ConnectionText.Text = "NOT CONNECTED TO THE SERVER";
            }
        }
    }
}
