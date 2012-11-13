#include "egoimap.h"

#include <iostream>

EgoiString * EgoiValue::asString() {
	return static_cast<EgoiString*>(this);
}

EgoiMap * EgoiValue::asMap() {
	return static_cast<EgoiMap*>(this);
}

EgoiMapList * EgoiValue::asMapList() {
	return static_cast<EgoiMapList*>(this);
}

std::string EgoiValue::egoiTypeName()
{
	switch(egoiType()) {
		case EGOI_TYPE_VALUE: return "EGOI_TYPE_VALUE";
		case EGOI_TYPE_STRING: return "EGOI_TYPE_STRING";
		case EGOI_TYPE_MAP: return "EGOI_TYPE_MAP";
		case EGOI_TYPE_MAP_LIST: return "EGOI_TYPE_MAP_LIST";
		default: return "Unknown type";
	}
}

std::ostream& operator<<(std::ostream & out, const EgoiValue & r) {
    return out << r.toString();
}

const std::string EgoiValue::toString() const {
    return "None";
}

//////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////// String ///////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////

const std::string EgoiString::toString() const
{
	return "\"" + value() + "\"";
}

std::string EgoiString::value() const {
	return m_value;
}

//////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////// Map ////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////

const std::string EgoiMap::toString() const
{
	std::string s;
	s.append("{");

	EgoiMap::iterator it;
	for(it = begin(); it != end(); it++) {
		if(it!=begin())
			s.append(", ");
		std::string _k = (*it).first;
		EgoiValue * _v = (*it).second;
		s.append("\"").append(_k).append("\": ").append(_v->toString());
	}

	s.append("}");
	return s;
}

EgoiValue * & EgoiMap::operator[] (const std::string & key) {
	return m_map[key];
}

//////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////// List ///////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////

const std::string EgoiMapList::toString() const
{
	std::string s;
	s.append("[");
	EgoiMapList::iterator it;
	for(it=begin(); it!=end(); it++) {
		if(it!=begin())
			s.append(", ");
		s.append((*it)->toString());
	}
	s.append("]");
	return s;
}

EgoiMapList EgoiMapList::operator << (EgoiValue * value)
{
	m_list.push_back(value);
	return * this;
}
