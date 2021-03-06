package net.oldhaven.customs;

public class CustomModelAlexArms {
    public float rotationPointX;
    public float rotationPointY;
    public float rotationPointZ;
    public float rotateAngleX;
    public float rotateAngleY;
    public float rotateAngleZ;
    private CustomModelRenderer alexArms;
    private CustomModelRenderer steveArms;
    public boolean isAlex = false;
    public boolean mirror = false;

    float f = 0;
    public CustomModelAlexArms(int i, int i2, float scale, float f) {
        this.f = f;
        this.alexArms = new CustomModelRenderer(i, i2);
        this.alexArms.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, scale, 64, 64);
        this.alexArms.setRotationPoint(5.0F, 2.0F, 0.0F);

        this.steveArms = new CustomModelRenderer(i, i2);
        this.steveArms.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, scale, 64, 64);
        this.steveArms.setRotationPoint(5.0F, 1.5F, 0.0F);
    }

    public void setRotationPoint(float var1, float var2, float var3) {
        this.rotationPointX = var1;
        this.rotationPointY = var2;
        this.rotationPointZ = var3;
    }

    public void setIsAlex(boolean b) {
        this.isAlex = b;
    }

    public CustomModelRenderer getModel()  {
        return isAlex ? alexArms : steveArms;
    }

    public void render(float scale) {
        if(isAlex) {
            if(!mirror)
                this.rotationPointX -= 1F;
            this.rotationPointY = 2.0F+f;
            doRotations(alexArms);
            alexArms.render(scale);
        } else {
            this.rotationPointY = 2.0F+f;
            doRotations(steveArms);
            steveArms.render(scale);
        }
    }

    public void postRender(float scale) {
        if (isAlex) {
            alexArms.postRender(scale);
        } else {
            steveArms.postRender(scale);
        }
    }

    private void doRotations(CustomModelRenderer arm) {
        arm.rotationPointX = this.rotationPointX;
        arm.rotationPointY = this.rotationPointY;
        arm.rotationPointZ = this.rotationPointZ;
        arm.rotateAngleX = this.rotateAngleX;
        arm.rotateAngleY = this.rotateAngleY;
        arm.rotateAngleZ = this.rotateAngleZ;
        arm.mirror = this.mirror;
    }
}
