package br.edu.ifpb.fcgp.academico.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.fcgp.academico.model.Usuario;

@FacesConverter(value = "generic", forClass = Usuario.class)
public class ConverterUsuario implements Converter, Serializable {
	
	private static final long serialVersionUID = 1L;

	public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
		if(value != null && !value.isEmpty()) {
			return(Usuario) comp.getAttributes().get(value);
		}
		

        return null;
    }

    public String getAsString(FacesContext ctx, UIComponent comp, Object obj) {
    	
    	if(obj instanceof Usuario) {
    		Usuario entity = (Usuario) obj;
    		if(entity instanceof Usuario && entity.getId() !=null) {
    			comp.getAttributes().put(entity.getId().toString(), entity);
    			return entity.getId().toString();
    		}
    		
    	}
    	
        return   "";
    }

}






























