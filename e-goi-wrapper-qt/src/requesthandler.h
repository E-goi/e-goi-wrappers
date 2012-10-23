#pragma once

#include <QObject>
#include <QVariant>

class RequestHandler : public QObject {

	Q_OBJECT

	public slots:
        void done(int id, QVariant v);

};
