#include <stdio.h>

#include <egoi.h>

#include <list>
#include <map>
#include <iostream>

#include <client.h>
#include <variant.h>
#include <requesthandler.h>

#include <QMap>
#include <QObject>
#include <QtDebug>
#include <QApplication>

int main(int argc, char ** argv) {
   QApplication app(argc, argv);

    xmlrpc::Client *client = new xmlrpc::Client();
    client->setHost("http://api.e-goi.com/v2/xmlrpc.php");

    RequestHandler * r = new RequestHandler();
    QObject::connect(client, SIGNAL(done(int,QVariant)), r, SLOT(done(int,QVariant)));

    QMap<QString, xmlrpc::Variant> map;
    map["apikey"] = "d7cdcc90c0547da5da90c3e14eeff180455c38a2";
    int response = client->request("getUserData", map);

    return app.exec();
}
