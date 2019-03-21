package ru.kogut.proxy;

import java.lang.reflect.Proxy;

/**
 * @author S.Kogut on 2019-03-21
 */
public class Main {

    private static CRUDOperation createClient(){

        CRUDOperation crudOperation = new Client();
        return (CRUDOperation)Proxy.newProxyInstance(
                Client.class.getClassLoader(),
                Client.class.getInterfaces(),
                new GlobalHandler(crudOperation)
        );

    }

    private static CRUDOperation createProduct(){
        CRUDOperation crudOperation = new Product();
        return (CRUDOperation)Proxy.newProxyInstance(
                Product.class.getClassLoader(),
                Product.class.getInterfaces(),
                new ProfilerHandler(crudOperation)
        );
    }

    private static CRUDOperation create(Table table) {
        switch (table) {
            case Client:
                return createClient();
            case Product:
                return createProduct();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        CRUDOperation client = create(Table.Client);
        realiseMethods(client);
        CRUDOperation product = create(Table.Product);
        realiseMethods(product);
    }

    public static void realiseMethods(CRUDOperation crudOperation){
        crudOperation.create();
        crudOperation.read();
        crudOperation.update();
        crudOperation.delete();
    }
}
