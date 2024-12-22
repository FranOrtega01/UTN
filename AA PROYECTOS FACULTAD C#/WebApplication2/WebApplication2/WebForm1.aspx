<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WebApplication2.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        #form1 {
            height: 325px;
        }
    </style>
</head>
<body style="height: 303px">
    <form id="form1" runat="server">
        <div>
            Ingrese nombre del producto:&nbsp;
            <asp:TextBox ID="txtProd1" runat="server"></asp:TextBox>
&nbsp; Cantidad:&nbsp;
            <asp:TextBox ID="txtQty1" runat="server"></asp:TextBox>
            <br />
            <br />
            Ingrese nombre del producto:&nbsp;
            <asp:TextBox ID="txtProd2" runat="server"></asp:TextBox>
&nbsp; Cantidad:
            <asp:TextBox ID="txtQty2" runat="server"></asp:TextBox>
            <br />
            <br />
        </div>
    &nbsp;&nbsp;&nbsp;
        <asp:Button ID="BtnTable" runat="server" OnClick="BtnTable_Click" Text="Generar Tabla" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Label ID="lblAlert" runat="server" ForeColor="#FF3300"></asp:Label>
        <br />
        <br />
&nbsp;&nbsp;&nbsp;
        <asp:Label ID="lblTable" runat="server"></asp:Label>
    </form>
</body>
</html>
