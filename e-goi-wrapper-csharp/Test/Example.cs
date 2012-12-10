using System;
using System.Collections.Generic;
using Egoi;
using CookComputing.XmlRpc;
using System.Net;
using System.IO;
using System.Xml.Linq;
using Newtonsoft.Json;

namespace Test
{
    class Example
    {

        static void Main(string[] args)
        {
            try
            {
                EgoiMap arguments = new EgoiMap();
                arguments.Add("apikey", "<api key>");

                // Default is XmlRpc, Rest is also available
                EgoiApi api = EgoiApiFactory.getApi(Protocol.Default);
                
                // Obter os dados do utilizador da ApiKey
                EgoiMap userData = api.getUserData(arguments);
                foreach(string key in userData.Keys) {
                    Console.WriteLine(key + "=" + userData[key]);
                }

                // Obter as listas
                EgoiMapList lists = api.getLists(arguments);
                foreach (EgoiMap list in lists) {
                    // Os tipos EgoiMap/EgoiMapList devolvem um output parecido com
                    // JSON no seu ToString()
                    Console.WriteLine(list);
                }

            }
            catch (EgoiException e)
            {
                Console.WriteLine("Ocorreu um erro: " + e.Message);
            }

            // Esperar por um enter na consola
            Console.Read();
        }
    }
}
