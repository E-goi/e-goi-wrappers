#pragma once

#include <iostream>
#include <string>
#include <list>
#include <map>

class EgoiMap;
class EgoiMapList;
class EgoiString;

class EgoiValue {

	public:

		//! Class type is None
		static const int EGOI_TYPE_VALUE = 0;

		//! Class type is String
		static const int EGOI_TYPE_STRING = 1;

		//! Class type is EgoiMap
		static const int EGOI_TYPE_MAP = 2;

		//! Class type is EgoiMapList
		static const int EGOI_TYPE_MAP_LIST = 3;

		EgoiValue() {}

		EgoiString * asString();
		EgoiMap * asMap();
		EgoiMapList * asMapList();

		virtual int egoiType() { return EGOI_TYPE_VALUE; }

		std::string egoiTypeName();

		friend std::ostream & operator<<(std::ostream & out, const EgoiValue & r);

		virtual const std::string toString() const;

};

class EgoiString : public EgoiValue {
	public:
		EgoiString() {}

		EgoiString(const char * value) : m_value(value) { }

		EgoiString(std::string value) : m_value(value) { }

		int egoiType() { return EGOI_TYPE_STRING; }

		const std::string toString() const;

		std::string value() const;

	private:
		std::string m_value;
};

class EgoiMap : public EgoiValue {

	public:

		EgoiMap() { }

		int egoiType() const { return EGOI_TYPE_MAP; }

		const std::string toString() const;

		EgoiValue * & operator[] (const std::string & key);

		typedef std::map<std::string, EgoiValue*>::const_iterator iterator;

		iterator begin() const { return m_map.begin(); }

		iterator end() const { return m_map.end(); }

	private:

		std::map<std::string, EgoiValue*> m_map;

};


class EgoiMapList : public EgoiValue {
	public:

		EgoiMapList() {}

		int egoiType() const { return EGOI_TYPE_MAP_LIST; }

		const std::string toString() const;

		typedef std::list<EgoiValue*>::const_iterator iterator;

		iterator begin() const { return m_list.begin(); }

		iterator end() const { return m_list.end(); }

		EgoiMapList operator<< (EgoiValue * value);

	private:
		std::list<EgoiValue*> m_list;
};
