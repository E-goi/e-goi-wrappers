using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Egoi
{
    public interface EgoiResellers
    {
        #region API Methods

        #region partners-products
        string getPartnersProducts(EgoiMap arguments);
        string getPartnersProductsById(string id, EgoiMap arguments);
        #endregion

        #region subaccounts-balance
        string getSubaccountsBalanceById(string id, EgoiMap arguments);
        #endregion

        #region subaccounts-operations
        string blockSubaccounts(EgoiMap arguments);
        string unblockSubaccounts(EgoiMap arguments);
        #endregion

        #region subaccounts
        string getSubaccounts(EgoiMap arguments);
        string addSubaccounts(EgoiMap arguments);
        string deleteSubaccounts(string id, EgoiMap arguments);
        string getSubaccountsById(string id, EgoiMap arguments);
        string updateSubaccounts(string id, EgoiMap arguments);
        #endregion

        #region subaccounts-products
        string addSubaccountsProducts(EgoiMap arguments);
        string deleteSubaccountsProducts(string id, EgoiMap arguments);
        string topupSubaccountsProducts(EgoiMap arguments);
        #endregion

        #region subaccounts-properties
        string getSubaccountsProperties(EgoiMap arguments);
        string getSubaccountsPropertiesById(string id, EgoiMap arguments);
        #endregion

        #endregion
    }
}
