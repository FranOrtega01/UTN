<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm2.aspx.cs" Inherits="WebApplication2.WebForm2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body style="height: 339px">
    <form id="form1" runat="server">
        <div>
            Nombre:&nbsp;&nbsp;
            <asp:TextBox ID="txtName" runat="server"></asp:TextBox>
            <br />
            <br />
            Apellido:&nbsp;&nbsp;
            <asp:TextBox ID="txtSurname" runat="server"></asp:TextBox>
            <br />
            <br />
            Ciudad:&nbsp; <asp:DropDownList ID="ddlCity" runat="server">
                <asp:ListItem Value="Zona Norte">Gral Pacheco</asp:ListItem>
                <asp:ListItem Value="Zona Oeste">San Miguel</asp:ListItem>
                <asp:ListItem Value="Zona Sur">Boedo</asp:ListItem>
            </asp:DropDownList>
            <br />
            <br />
            Temas:&nbsp;Temas:&nbsp;
            <asp:CheckBoxList ID="cblTemas" runat="server" Width="96px">
                <asp:ListItem>Ciencias</asp:ListItem>
                <asp:ListItem>Literatura</asp:ListItem>
                <asp:ListItem>Historia</asp:ListItem>
            </asp:CheckBoxList>
            <asp:Button ID="btnResumen" runat="server" OnClick="btnResumen_Click" Text="Button" />
            <br />
        </div>
    </form>
</body>
</html>
