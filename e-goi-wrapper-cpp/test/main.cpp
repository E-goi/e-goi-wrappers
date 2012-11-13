#include <stdio.h>

#include <egoi.h>
#include <egoimap.h>

#define API_KEY     "<api key>"

#include <egoi.h>

int main(int argc, char ** argv) {
    try {

        EgoiApi * api = Egoi::getApi();

        EgoiMap functionOptions;
        functionOptions["apikey"] =  new EgoiString(API_KEY);
        EgoiMapList value = api->getSenders(functionOptions);

        std::cout << value;

    } catch(EgoiException e) {
        std::cout << e.what() << std::endl;
    }

    return 0;
}
