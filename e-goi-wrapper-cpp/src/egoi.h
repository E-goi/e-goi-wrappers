#pragma once

#include <map>
#include <string>

#include "egoimap.h"

class EgoiException : public std::exception
{
    public:
        EgoiException(std::string message) : m_error(message) {

        }

        virtual ~EgoiException() throw() {}

        const char* what() const throw() { return m_error.c_str(); }

    private:
        std::string m_error;

};


class EgoiApi {

    public:
        virtual EgoiMap getUserData(EgoiMap & functionOptions) const = 0;
        virtual EgoiMapList getLists(EgoiMap & functionOptions) const = 0;

};


class Egoi
{

    Egoi();

	public:

        static EgoiApi * getApi();

};
