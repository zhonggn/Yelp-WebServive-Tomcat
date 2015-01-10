package Connection;

public class ServiceProxy implements Connection.Service {
  private String _endpoint = null;
  private Connection.Service service = null;
  
  public ServiceProxy() {
    _initServiceProxy();
  }
  
  public ServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProxy();
  }
  
  private void _initServiceProxy() {
    try {
      service = (new Connection.ServiceServiceLocator()).getService();
      if (service != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service != null)
      ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Connection.Service getService() {
    if (service == null)
      _initServiceProxy();
    return service;
  }
  
  public java.lang.String signIn(java.lang.String useremail, java.lang.String pwd) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signIn(useremail, pwd);
  }
  
  public java.lang.String signUp(java.lang.String fname, java.lang.String lname, java.lang.String useremail, java.lang.String pwd) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signUp(fname, lname, useremail, pwd);
  }
  
  public model.Category[] getCategory(java.lang.String sql) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getCategory(sql);
  }
  
  public model.User[] getUser(java.lang.String sql) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getUser(sql);
  }
  
  public java.lang.String addCategory(java.lang.String sql) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.addCategory(sql);
  }
  
  public model.Element[] getElement(int cid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getElement(cid);
  }
  
  public model.Element getElemInfo(java.lang.String sql) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getElemInfo(sql);
  }
  
  public java.lang.String addreview(java.lang.String review, java.lang.String rate, java.lang.String eleid, java.lang.String email) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.addreview(review, rate, eleid, email);
  }
  
  public model.Review[] getReview(int uid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getReview(uid);
  }
  
  public java.lang.String addElement(java.lang.String ename, java.lang.String des, java.lang.String rate, java.lang.String catName, java.lang.String review, int uid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.addElement(ename, des, rate, catName, review, uid);
  }
  
  public java.lang.String signOut(java.lang.String email) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signOut(email);
  }
  
  public java.lang.String deleteCat(java.lang.String cname) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.deleteCat(cname);
  }
  
  public java.lang.String deleteElem(java.lang.String ename) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.deleteElem(ename);
  }
  
  
}