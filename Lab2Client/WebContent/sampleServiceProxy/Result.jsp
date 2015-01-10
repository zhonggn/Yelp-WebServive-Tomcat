<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServiceProxyid" scope="session" class="Connection.ServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        Connection.Service getService10mtemp = sampleServiceProxyid.getService();
if(getService10mtemp == null){
%>
<%=getService10mtemp %>
<%
}else{
        if(getService10mtemp!= null){
        String tempreturnp11 = getService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String useremail_1id=  request.getParameter("useremail16");
            java.lang.String useremail_1idTemp = null;
        if(!useremail_1id.equals("")){
         useremail_1idTemp  = useremail_1id;
        }
        String pwd_2id=  request.getParameter("pwd18");
            java.lang.String pwd_2idTemp = null;
        if(!pwd_2id.equals("")){
         pwd_2idTemp  = pwd_2id;
        }
        java.lang.String signIn13mtemp = sampleServiceProxyid.signIn(useremail_1idTemp,pwd_2idTemp);
if(signIn13mtemp == null){
%>
<%=signIn13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signIn13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 20:
        gotMethod = true;
        String fname_3id=  request.getParameter("fname23");
            java.lang.String fname_3idTemp = null;
        if(!fname_3id.equals("")){
         fname_3idTemp  = fname_3id;
        }
        String lname_4id=  request.getParameter("lname25");
            java.lang.String lname_4idTemp = null;
        if(!lname_4id.equals("")){
         lname_4idTemp  = lname_4id;
        }
        String useremail_5id=  request.getParameter("useremail27");
            java.lang.String useremail_5idTemp = null;
        if(!useremail_5id.equals("")){
         useremail_5idTemp  = useremail_5id;
        }
        String pwd_6id=  request.getParameter("pwd29");
            java.lang.String pwd_6idTemp = null;
        if(!pwd_6id.equals("")){
         pwd_6idTemp  = pwd_6id;
        }
        java.lang.String signUp20mtemp = sampleServiceProxyid.signUp(fname_3idTemp,lname_4idTemp,useremail_5idTemp,pwd_6idTemp);
if(signUp20mtemp == null){
%>
<%=signUp20mtemp %>
<%
}else{
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signUp20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
}
break;
case 31:
        gotMethod = true;
        String sql_7id=  request.getParameter("sql34");
            java.lang.String sql_7idTemp = null;
        if(!sql_7id.equals("")){
         sql_7idTemp  = sql_7id;
        }
        model.Category[] getCategory31mtemp = sampleServiceProxyid.getCategory(sql_7idTemp);
if(getCategory31mtemp == null){
%>
<%=getCategory31mtemp %>
<%
}else{
        String tempreturnp32 = null;
        if(getCategory31mtemp != null){
        java.util.List listreturnp32= java.util.Arrays.asList(getCategory31mtemp);
        tempreturnp32 = listreturnp32.toString();
        }
        %>
        <%=tempreturnp32%>
        <%
}
break;
case 36:
        gotMethod = true;
        String sql_8id=  request.getParameter("sql39");
            java.lang.String sql_8idTemp = null;
        if(!sql_8id.equals("")){
         sql_8idTemp  = sql_8id;
        }
        model.User[] getUser36mtemp = sampleServiceProxyid.getUser(sql_8idTemp);
if(getUser36mtemp == null){
%>
<%=getUser36mtemp %>
<%
}else{
        String tempreturnp37 = null;
        if(getUser36mtemp != null){
        java.util.List listreturnp37= java.util.Arrays.asList(getUser36mtemp);
        tempreturnp37 = listreturnp37.toString();
        }
        %>
        <%=tempreturnp37%>
        <%
}
break;
case 41:
        gotMethod = true;
        String sql_9id=  request.getParameter("sql44");
            java.lang.String sql_9idTemp = null;
        if(!sql_9id.equals("")){
         sql_9idTemp  = sql_9id;
        }
        java.lang.String addCategory41mtemp = sampleServiceProxyid.addCategory(sql_9idTemp);
if(addCategory41mtemp == null){
%>
<%=addCategory41mtemp %>
<%
}else{
        String tempResultreturnp42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addCategory41mtemp));
        %>
        <%= tempResultreturnp42 %>
        <%
}
break;
case 46:
        gotMethod = true;
        String cid_10id=  request.getParameter("cid49");
        int cid_10idTemp  = Integer.parseInt(cid_10id);
        model.Element[] getElement46mtemp = sampleServiceProxyid.getElement(cid_10idTemp);
if(getElement46mtemp == null){
%>
<%=getElement46mtemp %>
<%
}else{
        String tempreturnp47 = null;
        if(getElement46mtemp != null){
        java.util.List listreturnp47= java.util.Arrays.asList(getElement46mtemp);
        tempreturnp47 = listreturnp47.toString();
        }
        %>
        <%=tempreturnp47%>
        <%
}
break;
case 51:
        gotMethod = true;
        String sql_11id=  request.getParameter("sql64");
            java.lang.String sql_11idTemp = null;
        if(!sql_11id.equals("")){
         sql_11idTemp  = sql_11id;
        }
        model.Element getElemInfo51mtemp = sampleServiceProxyid.getElemInfo(sql_11idTemp);
if(getElemInfo51mtemp == null){
%>
<%=getElemInfo51mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">eid:</TD>
<TD>
<%
if(getElemInfo51mtemp != null){
%>
<%=getElemInfo51mtemp.getEid()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ename:</TD>
<TD>
<%
if(getElemInfo51mtemp != null){
java.lang.String typeename56 = getElemInfo51mtemp.getEname();
        String tempResultename56 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeename56));
        %>
        <%= tempResultename56 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">rating:</TD>
<TD>
<%
if(getElemInfo51mtemp != null){
%>
<%=getElemInfo51mtemp.getRating()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">description:</TD>
<TD>
<%
if(getElemInfo51mtemp != null){
java.lang.String typedescription60 = getElemInfo51mtemp.getDescription();
        String tempResultdescription60 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription60));
        %>
        <%= tempResultdescription60 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cid:</TD>
<TD>
<%
if(getElemInfo51mtemp != null){
%>
<%=getElemInfo51mtemp.getCid()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 66:
        gotMethod = true;
        String review_12id=  request.getParameter("review69");
            java.lang.String review_12idTemp = null;
        if(!review_12id.equals("")){
         review_12idTemp  = review_12id;
        }
        String rate_13id=  request.getParameter("rate71");
            java.lang.String rate_13idTemp = null;
        if(!rate_13id.equals("")){
         rate_13idTemp  = rate_13id;
        }
        String eleid_14id=  request.getParameter("eleid73");
            java.lang.String eleid_14idTemp = null;
        if(!eleid_14id.equals("")){
         eleid_14idTemp  = eleid_14id;
        }
        String email_15id=  request.getParameter("email75");
            java.lang.String email_15idTemp = null;
        if(!email_15id.equals("")){
         email_15idTemp  = email_15id;
        }
        java.lang.String addreview66mtemp = sampleServiceProxyid.addreview(review_12idTemp,rate_13idTemp,eleid_14idTemp,email_15idTemp);
if(addreview66mtemp == null){
%>
<%=addreview66mtemp %>
<%
}else{
        String tempResultreturnp67 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addreview66mtemp));
        %>
        <%= tempResultreturnp67 %>
        <%
}
break;
case 77:
        gotMethod = true;
        String uid_16id=  request.getParameter("uid80");
        int uid_16idTemp  = Integer.parseInt(uid_16id);
        model.Review[] getReview77mtemp = sampleServiceProxyid.getReview(uid_16idTemp);
if(getReview77mtemp == null){
%>
<%=getReview77mtemp %>
<%
}else{
        String tempreturnp78 = null;
        if(getReview77mtemp != null){
        java.util.List listreturnp78= java.util.Arrays.asList(getReview77mtemp);
        tempreturnp78 = listreturnp78.toString();
        }
        %>
        <%=tempreturnp78%>
        <%
}
break;
case 82:
        gotMethod = true;
        String ename_17id=  request.getParameter("ename85");
            java.lang.String ename_17idTemp = null;
        if(!ename_17id.equals("")){
         ename_17idTemp  = ename_17id;
        }
        String des_18id=  request.getParameter("des87");
            java.lang.String des_18idTemp = null;
        if(!des_18id.equals("")){
         des_18idTemp  = des_18id;
        }
        String rate_19id=  request.getParameter("rate89");
            java.lang.String rate_19idTemp = null;
        if(!rate_19id.equals("")){
         rate_19idTemp  = rate_19id;
        }
        String catName_20id=  request.getParameter("catName91");
            java.lang.String catName_20idTemp = null;
        if(!catName_20id.equals("")){
         catName_20idTemp  = catName_20id;
        }
        String review_21id=  request.getParameter("review93");
            java.lang.String review_21idTemp = null;
        if(!review_21id.equals("")){
         review_21idTemp  = review_21id;
        }
        String uid_22id=  request.getParameter("uid95");
        int uid_22idTemp  = Integer.parseInt(uid_22id);
        java.lang.String addElement82mtemp = sampleServiceProxyid.addElement(ename_17idTemp,des_18idTemp,rate_19idTemp,catName_20idTemp,review_21idTemp,uid_22idTemp);
if(addElement82mtemp == null){
%>
<%=addElement82mtemp %>
<%
}else{
        String tempResultreturnp83 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addElement82mtemp));
        %>
        <%= tempResultreturnp83 %>
        <%
}
break;
case 97:
        gotMethod = true;
        String email_23id=  request.getParameter("email100");
            java.lang.String email_23idTemp = null;
        if(!email_23id.equals("")){
         email_23idTemp  = email_23id;
        }
        java.lang.String signOut97mtemp = sampleServiceProxyid.signOut(email_23idTemp);
if(signOut97mtemp == null){
%>
<%=signOut97mtemp %>
<%
}else{
        String tempResultreturnp98 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signOut97mtemp));
        %>
        <%= tempResultreturnp98 %>
        <%
}
break;
case 102:
        gotMethod = true;
        String cname_24id=  request.getParameter("cname105");
            java.lang.String cname_24idTemp = null;
        if(!cname_24id.equals("")){
         cname_24idTemp  = cname_24id;
        }
        java.lang.String deleteCat102mtemp = sampleServiceProxyid.deleteCat(cname_24idTemp);
if(deleteCat102mtemp == null){
%>
<%=deleteCat102mtemp %>
<%
}else{
        String tempResultreturnp103 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteCat102mtemp));
        %>
        <%= tempResultreturnp103 %>
        <%
}
break;
case 107:
        gotMethod = true;
        String ename_25id=  request.getParameter("ename110");
            java.lang.String ename_25idTemp = null;
        if(!ename_25id.equals("")){
         ename_25idTemp  = ename_25id;
        }
        java.lang.String deleteElem107mtemp = sampleServiceProxyid.deleteElem(ename_25idTemp);
if(deleteElem107mtemp == null){
%>
<%=deleteElem107mtemp %>
<%
}else{
        String tempResultreturnp108 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteElem107mtemp));
        %>
        <%= tempResultreturnp108 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>