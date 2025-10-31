package repository.querys.ownerQuerys;

public enum OwnerQuery {
    FIND_BY_MOBILE_NUMBER("SELECT * FROM owner WHERE mobileNumber = ?"),
    FIND_BY_COMPANY_NAME_AND_CITY("SELECT USERID FROM OWNER WHERE HEADOFFICECITY = ? AND COMPANYNAME = ?"),
    FIND_BY_GST_NUMBER("SELECT USERID FROM OWNER WHERE GSTNUMBER = ?"),
    INSERT_OWNER_AND_RETURN_ID("INSERT INTO OWNER (USERNAME, PASSWORD , MOBILENUMBER , COMPANYNAME , GSTNUMBER , HEADOFFICECITY) VALUES(?,?,?,?,?,?)"),
    FIND_BY_MOBILE_NUMBER_AND_PASSWORD("SELECT userId , password FROM owner WHERE MOBILENUMBER = ?");

    private final String query;

    OwnerQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
