package com.esotericsoftware.reflectasm.shaded.org.objectweb.asm;

public abstract class ClassVisitor
{
  protected final int api;
  protected ClassVisitor cv;

  public ClassVisitor(int paramInt)
  {
    this(paramInt, null);
  }

  public ClassVisitor(int paramInt, ClassVisitor paramClassVisitor)
  {
    this.api = paramInt;
    this.cv = paramClassVisitor;
  }

  public void visit(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (this.cv != null)
      this.cv.visit(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramArrayOfString);
  }

  public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean)
  {
    if (this.cv != null)
      return this.cv.visitAnnotation(paramString, paramBoolean);
    return null;
  }

  public void visitAttribute(Attribute paramAttribute)
  {
    if (this.cv != null)
      this.cv.visitAttribute(paramAttribute);
  }

  public void visitEnd()
  {
    if (this.cv != null)
      this.cv.visitEnd();
  }

  public FieldVisitor visitField(int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    if (this.cv != null)
      return this.cv.visitField(paramInt, paramString1, paramString2, paramString3, paramObject);
    return null;
  }

  public void visitInnerClass(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.cv != null)
      this.cv.visitInnerClass(paramString1, paramString2, paramString3, paramInt);
  }

  public MethodVisitor visitMethod(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (this.cv != null)
      return this.cv.visitMethod(paramInt, paramString1, paramString2, paramString3, paramArrayOfString);
    return null;
  }

  public void visitOuterClass(String paramString1, String paramString2, String paramString3)
  {
    if (this.cv != null)
      this.cv.visitOuterClass(paramString1, paramString2, paramString3);
  }

  public void visitSource(String paramString1, String paramString2)
  {
    if (this.cv != null)
      this.cv.visitSource(paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.ClassVisitor
 * JD-Core Version:    0.6.2
 */