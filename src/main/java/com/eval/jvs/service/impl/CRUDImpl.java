package com.eval.jvs.service.impl;

//import java.lang.reflect.Method;
import java.util.List;

import com.eval.jvs.exception.ModelNotFoundException;
import com.eval.jvs.model.Identifiable;
import com.eval.jvs.repository.IGenericRepostory;
import com.eval.jvs.service.ICRUD;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID>{

    protected abstract IGenericRepostory<T,ID> getRepository();

    @Override
    public List<T> findAll() throws Exception {
        return getRepository().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        // no nulos
        return getRepository().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public T save(T t) throws Exception {
        return getRepository().save(t);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T update(T t, ID id) throws Exception {
        if (t instanceof Identifiable) {
            ((Identifiable<ID>) t).setId(id);
        } else {
            throw new IllegalArgumentException("La entidad no es identificable.");
        }

        getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
        return getRepository().save(t);
    }

    // @Override
    // public T update(T t, ID id) throws Exception {
    //     Class<?> myClass = t.getClass(); // aca tenemos la clase
    //     String nameClass = myClass.getSimpleName(); // el nombre de la clase

    //     String nameMethod = "setId" + nameClass;// setId + T,....... setIdCurso, setIdEstudiante, ......
    //     Method setIdMethod = myClass.getMethod(nameMethod,id.getClass());// definimos el metodo
    //     setIdMethod.invoke(t,id); // ejecutamos el metodo.
        
    //     getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));


    //     return getRepository().save(t);
    // }

    @Override
    public void deleteById(ID id) throws Exception {
        getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
        getRepository().deleteById(id);
    }
    
}
