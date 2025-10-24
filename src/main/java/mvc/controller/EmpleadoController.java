package mvc.controller;

import mvc.model.entity.Empleado;
import mvc.model.repository.EmpleadoRepository;
import mvc.model.repository.RepositoryException;
import mvc.model.service.EmpleadoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


//Implememtación del servlet
@WebServlet("/EmpleadoController")
public class EmpleadoController extends HttpServlet {
    //identificador de versión de serialización de una clase para controlar las versiones
    private static final long serialVersionUID = 1L;

    public EmpleadoController() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        RequestDispatcher rd = null;

        if (option == null) {
            option = "default";
        }
        try {
            switch (option) {
                case "listarEmpleados":
                    List<Empleado> listaEmpleados = EmpleadoRepository.findAll();
                    request.setAttribute("listaEmpleados", listaEmpleados);
                    rd =  request.getRequestDispatcher("/WEB-INF/listarEmpleados.jsp");
                    break;
                case "default":rd = request.getRequestDispatcher("/WEB-INF/listarEmpleados.jsp");
            }
        }catch (RepositoryException e){
            e.printStackTrace();
            throw new ServletException("Error en la capa de repositorio: " + e.getMessage());
        }
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

//    private void findAllCustomers(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<Empleado> list;
//        try {
//            list = EmpleadoService.findAll();
//            request.setAttribute("customerList", list);
//            RequestDispatcher rd = request.getRequestDispatcher("find-all.jsp");
//            rd.forward(request, response);
//        } catch (RepositoryException e) {
//            // Imprimimos el detalle en la consola
//            e.printStackTrace();
//            request.setAttribute("error", "Se produjo un error al acceder al repositorio de datos");
//            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
//            rd.forward(request, response);
//        }
//    }
}
