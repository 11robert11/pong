package com.company;


import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.glfw.GLFW.*;

class Window
{
    private Logger logger = Logger.getLogger(Window.class.getName());

    private int width, height;
    private String title;
    private static Window window = null;
    private long glfwWindow;
    private Window()
    {
        this.width = 720;
        this.height = 800;
        this.title = "Window";
    }
    public static Window get()
    {
        if(Window.window == null)
        {
            Window.window = new Window();
        }
        return Window.window;
    }
    public void run()
    {
        logger.log(Level.INFO, "LWJGL Version: " + Version.getVersion());
        init();
        loop();

    }
    private void memClean()
    {
        glfwFreeCallbacks(glfwWindow);
        glfwDestroyWindow(glfwWindow);

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    private void init()
    {
        GLFWErrorCallback.createPrint(System.err).set();

        ///////////

        if(!glfwInit())
        {
            throw new IllegalStateException("Could Not initialize GLFW");
        }

        //////////

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        //////////

        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
        //glfwWindow is actually a mem address

        if (glfwWindow == NULL)
        {
            throw new IllegalStateException("Failed to create the GLFW window");
        }

        glfwMakeContextCurrent(glfwWindow);

        glfwSwapInterval(1);

        //////

        glfwShowWindow(glfwWindow);


        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();
    }
    private void loop()
    {
        while (!glfwWindowShouldClose(glfwWindow))
        {
            glfwPollEvents();

            glClearColor(1,0,0,0);
            glClear(GL_COLOR_BUFFER_BIT);

            glfwSwapBuffers(glfwWindow);
        }
    }
}