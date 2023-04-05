package br.ufrn.listataniro;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TarefaController {
    
    @PostMapping("/cadastrar")
    public void doCadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException{

        Tarefa tarefa;
        TarefaDAO tarefaDAO = new TarefaDAO();
        
        var texto = request.getParameter("texto");
        var prioridade = Integer.parseInt(request.getParameter("prioridade"));

        tarefa = new Tarefa(texto, prioridade);
        tarefaDAO.inserir(tarefa);

        response.setContentType("text/HTML");
        var writer = response.getWriter();

        writer.println("<html>" +
            "<body>" +
            "<h1> Descrição: " + texto + "</h1>" +
            "<h2> Prioridade: " + prioridade + "</h2>" +
            "</body>" +
            "</html>"
        );
    }

    @GetMapping("/doListar")
    public void doListar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        TarefaDAO tarefaDAO = new TarefaDAO();
        ArrayList<Tarefa> tarefas = tarefaDAO.listar();
        
        response.setContentType("text/HTML");
        var writer = response.getWriter();

        writer.println("<html>" +
            "<body>"+
            "<h1>TODAS AS TAREFAS</h1></br></hr>"
        );
        
        for (var t : tarefas) {
            writer.println("<p><b>Descrição:</b> "+ t.getTexto() +"</p></br>"+
                "<p><b>Prioridade:</b> "+ t.getPrioridade() + "</p></br>"+
                "<p><b>Data:</b> "+ t.getDataCadastro() + "</p></br><hr>"
            );
        }
        
        writer.println("</body>" +
            "</html>"
        );
    }
}