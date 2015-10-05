package com.sourav.audataskhow;

/**
 * Created by Hasmath on 10/4/2015.
 */
public  class Item {

    static long id = 0L;
    long mId;

    int image;
    String identity,type,details;

    public Item()
    {
        long l = id;
        id = 1L + l;
        this.mId = l;
    }

    long getId()
    {
        return this.mId;
    }

    public void setIdentity(String identity)
    {
        this.identity=identity;
    }
    public String getIdentity()
    {
        return this.identity;
    }


    public void setType(String type)
    {
        this.type=type;
    }
    public String getType()
    {
        return this.type;
    }
    public void setDetails(String details)
    {
        this.details=details;
    }
    public String getDetails()
    {
        return this.details;
    }

    public void setImage(int image)
    {
        this.image=image;
    }
    public int getImage()
    {
        return this.image;
    }


}
