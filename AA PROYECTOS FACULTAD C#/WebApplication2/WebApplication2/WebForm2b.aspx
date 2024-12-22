<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm2b.aspx.cs" Inherits="WebApplication2.WebForm2b" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div style="margin-left: 40px">
            <asp:Label ID="Label1" runat="server" Font-Bold="True" Font-Size="28pt" Text="Resumen"></asp:Label>
            <br />
            <br />
            Nombre:
            <asp:Label ID="txtName" runat="server"></asp:Label>
            <br />
&nbsp;&nbsp;&nbsp;
            <br />
            Apellido:
            <asp:Label ID="txtSurname" runat="server"></asp:Label>
            <br />
            <br />
            Ciudad:
            <asp:Label ID="txtCity" runat="server"></asp:Label>
            <br />
            <br />
            Temas:
            <br />
            <asp:Label ID="txtTemas" runat="server"></asp:Label>
            <br />
&nbsp;&nbsp;&nbsp;
        </div>
    </form>
</body>
</html>
