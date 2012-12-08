using System;
using System.Collections.Generic;
using Egoi;
using CookComputing.XmlRpc;

namespace Test
{
    class Program
    {

        static void Main(string[] args)
        {
            try
            {
                EgoiMap arguments = new EgoiMap();
                arguments.Add("apikey", "d7cdcc90c0547da5da90c3e14eeff180455c38a2");
                EgoiApi api = EgoiApiFactory.getApi();
                // EgoiMapList map = api.getLists(arguments);
                EgoiMap map = api.getUserData(arguments);
                Console.WriteLine(map);
            }
            catch (EgoiException e)
            {
                Console.WriteLine("Ocorreu um erro: " + e.Message);
            }
            Console.Read();
        }
    }
}
