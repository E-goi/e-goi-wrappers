#include "requesthandler.h"

#include <QtDebug>

void RequestHandler::done(int id, QVariant value) {
    qDebug() << value;
}
