/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public interface Service extends java.rmi.Remote {
    public model.Element[] getElement(int cid) throws java.rmi.RemoteException;
    public java.lang.String addElement(java.lang.String ename, java.lang.String des, java.lang.String rate, java.lang.String catName, java.lang.String review, int uid) throws java.rmi.RemoteException;
    public model.Element getElemInfo(java.lang.String sql) throws java.rmi.RemoteException;
    public java.lang.String addreview(java.lang.String review, java.lang.String rate, java.lang.String eleid, java.lang.String email) throws java.rmi.RemoteException;
    public model.User[] getUser(java.lang.String sql) throws java.rmi.RemoteException;
    public model.Category[] getCategory(java.lang.String sql) throws java.rmi.RemoteException;
    public java.lang.String signUp(java.lang.String fname, java.lang.String lname, java.lang.String useremail, java.lang.String pwd) throws java.rmi.RemoteException;
    public java.lang.String signIn(java.lang.String useremail, java.lang.String pwd) throws java.rmi.RemoteException;
    public java.lang.String signOut(java.lang.String email) throws java.rmi.RemoteException;
    public java.lang.String deleteElem(java.lang.String ename) throws java.rmi.RemoteException;
    public java.lang.String addCategory(java.lang.String sql) throws java.rmi.RemoteException;
    public model.Review[] getReview(int uid) throws java.rmi.RemoteException;
    public java.lang.String deleteCat(java.lang.String cname) throws java.rmi.RemoteException;
}
