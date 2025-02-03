package edu.pucmm.a1;

import io.javalin.Javalin;


public class Main {
    public static void main(String[] args){
        System.out.println("Hello World!");
        var app = Javalin.create(javalinConfig ->{
            javalinConfig.staticFiles.add("/publico");
        })
            .get("/", ctx -> ctx.result("Bienvenidos!"))
            .start(7000);

        // filtro before
        app.before("/", ctx ->{
            System.out.println("Filtro de la barra...");
            // Validacion
            Usuario usuario = ctx.sessionAttribute("USUARIO");
            if (usuario == null){
                // no ha sido encontrado
                ctx.redirect("/formulario.html");
            }
            System.out.println("Usuario: "+usuario);
        });

        app.post("/autenticar", ctx -> {
            String nombre = ctx.formParam("nombre");
            String contrasena = ctx.formParam("password");

            if(true);
            // simplificando muchas cosas
            Usuario usuario = new Usuario(nombre, "ICC", 1);
            ctx.sessionAttribute("USUARIO", usuario);
            ctx.redirect("/");
            
            
        });
    }
}

record Usuario(String nombre, String carrera, int id){
    //
}
