package controller;

import dao.CadastroProdutosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import model.CadastroProdutoModel;

@WebServlet("/cadastroProdutos")
public class CadastroProdutosController extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CadastroProdutoModel produto = new CadastroProdutoModel();
        
        produto.setCodigoBarras(request.getParameter("codigoBarras"));
        produto.setNomeProduto(request.getParameter("nomeProduto"));
        produto.setFabricante(request.getParameter("fabricante"));
        produto.setMarca(request.getParameter("marca"));
        produto.setDataFabricacao(request.getParameter("dataFabricacao"));
        produto.setDataVencimento(request.getParameter("dataVencimento"));
        produto.setQuantidade(Long.parseLong(request.getParameter("quantidade")));
        
        produto.setValor(new BigDecimal(request.getParameter("valor")));
        produto.setTotal(new BigDecimal(request.getParameter("total")));
        produto.setStatus(request.getParameter("status"));
        
        CadastroProdutosDAO dao = new CadastroProdutosDAO();
        
        if (dao.salvar(produto)) {
            response.sendRedirect("pages/dashboard.html");
        } else {
            response.sendRedirect("pages/cadastro.html");
        }
    }
}