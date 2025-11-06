package mvc.controller;

import mvc.model.entity.Empleado;
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
import java.util.Optional;


//Patrón: Front Controller (Controlador Frontal).
//Este servlet implementa el patrón Front Controller.
//Actúa como un único punto de entrada para todas las peticiones relacionadas con los empleados.
//Utiliza el parámetro "option" y un 'switch' para redirigir internamente la petición a la lógica de negocio correspondiente.


@WebServlet("/EmpleadoController")
public class EmpleadoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmpleadoController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        RequestDispatcher rd = null;

        System.out.println("--- OPCIÓN RECIBIDA POR EL SERVLET: '" + option + "' ---");

        if (option == null) {
            option = "default";
        }
        try {
            switch (option) {
                case "listarEmpleados":

                    List<Empleado> listaEmpleados = EmpleadoService.findAll();

                    request.setAttribute("listaDeEmpleados", listaEmpleados);

                    rd = request.getRequestDispatcher("/listarEmpleados.jsp");
                    break;

                case "calcularSalario":
                    try {
                        String dni = request.getParameter("dni");
                        Optional<Empleado> Empleado = EmpleadoService.findByDni(dni);

                        if (Empleado.isPresent()) {
                            Empleado empleado = Empleado.get();
                            double salario = EmpleadoService.calcularSueldo(empleado);
                            request.setAttribute("dniConsultado", dni);
                            request.setAttribute("salarioCalculado", salario);
                            rd = request.getRequestDispatcher("/mostrarSalario.jsp");

                        } else {
                            throw new Exception("Empleado no encontrado con DNI: " + dni);
                        }

                    } catch (Exception e) {
                        request.setAttribute("error", e.getMessage());
                        rd = request.getRequestDispatcher("/error.jsp");
                    }
                    break;

                case "buscarEmpleados":

                    String filtro = request.getParameter("filtro");
                    List<Empleado> empleadosEncontrados = EmpleadoService.buscarPorFiltro(filtro);
                    request.setAttribute("listaResultados", empleadosEncontrados);
                    rd = request.getRequestDispatcher("/resultadoBusqueda.jsp");
                    break;

                case "default":
                default:

                    rd = request.getRequestDispatcher("/index.jsp");
                    break;
            }
        } catch (RepositoryException e) {
            e.printStackTrace();
            throw new ServletException("Error en la capa de repositorio: " + e.getMessage());
        }
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


