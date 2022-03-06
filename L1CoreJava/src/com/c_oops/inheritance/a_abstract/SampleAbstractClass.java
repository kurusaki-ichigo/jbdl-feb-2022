package com.c_oops.inheritance.a_abstract;

public abstract class SampleAbstractClass {

    public abstract void renderResults();


    /**
     * pattern --
     *      procedure/ process
     *
     *   Booking.com
     *      -- aggregator for search results
     *
     *      ----> passengerInfo {
     *          "dateOfJourney" :
     *              "no of passenger" :
     *              "productTYpe" :
     *      }
     *          ---> searcher (Adamdeus , Galileo , Sabre) (source / suppliers)
     *                  -----> pricing information
     *                          -------> discounts (default codes) , / commission / markup
     *                                  --> rendering all the results in paginated view
     *
     *
     *        all of the similar / different product type
     *          - Air (Adamdeus , Galileo , Sabre)
     *              _ Hotel (trivago , )
     *                  - visa
     *                      - insurance (ICICI,  AMEX , different portners , HDFC)
     *
     *
     *
     */

    protected Object search(Object passengerInfo){
        seachingSuppliers();
        computePricing();
        return passengerInfo;
    }



    protected abstract void computePricing();

    protected abstract void seachingSuppliers();

}
