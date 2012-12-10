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
                arguments.Add("apikey", "d7cdcc90c0547da5da90c3e14eeff180455c38a2");

                EgoiApiRestImpl api = EgoiApiRestImpl.getInstance();
                Console.WriteLine(api.buildUrl("getLists", arguments));

                /*
                EgoiApi api = EgoiApiFactory.getApi();
                
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
                }*/

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
