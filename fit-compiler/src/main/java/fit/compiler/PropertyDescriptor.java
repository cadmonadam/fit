package fit.compiler;

import com.squareup.javapoet.TypeName;
import javax.lang.model.element.Element;

/**
 * @author Tu enum@foxmail.com.
 */

public class PropertyDescriptor {
  private String name;
  private String writeMethodName;
  private String readMethodName;
  private TypeName typeName;

  public PropertyDescriptor(Element field) {
    name = field.getSimpleName().toString();
    typeName = TypeName.get(field.asType());
  }

  public PropertyDescriptor(Element field, Element setter) {
    this(field);
    writeMethodName = setter.getSimpleName().toString();
  }

  public PropertyDescriptor(Element field, Element setter, Element getter) {
    this(field);
    writeMethodName = setter.getSimpleName().toString();
    setGetter(getter);
  }

  public void setGetter(Element getter) {
    readMethodName = getter.getSimpleName().toString();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWriteMethodName() {
    return writeMethodName;
  }

  public void setWriteMethodName(String writeMethodName) {
    this.writeMethodName = writeMethodName;
  }

  public String getReadMethodName() {
    return readMethodName;
  }

  public void setReadMethodName(String readMethodName) {
    this.readMethodName = readMethodName;
  }

  public TypeName getTypeName() {
    return typeName;
  }

  public void setTypeName(TypeName typeName) {
    this.typeName = typeName;
  }

  @Override public String toString() {
    return "PropertyDescriptor{"
        + "name='"
        + name
        + '\''
        + ", writeMethodName='"
        + writeMethodName
        + '\''
        + ", readMethodName='"
        + readMethodName
        + '\''
        + ", typeName="
        + typeName
        + '}';
  }
}
