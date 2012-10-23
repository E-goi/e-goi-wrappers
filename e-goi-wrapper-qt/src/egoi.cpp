#include "egoi.h"


Egoi::Egoi()
{
}

EgoiApi * Egoi::getApi()
{
    return new EgoiApi();
}
