package com.example.proklimjobenlestari.Domain;

import java.io.Serializable;

public class WisataDomain implements Serializable{
    private String title;
    private String pic;
    private String description;
    private String urlvideo;
    private String detailDescription;
    private String fasilitas;
    private String jarak;

    public WisataDomain(String title, String pic, String description) {
        this.title = title;
        this.pic = pic;
        this.description = description;
    }

    public WisataDomain(String title, String pic, String description, String detailDescription, String fasilitas, String jarak, String urlvideo) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.detailDescription =  detailDescription;
        this.fasilitas = fasilitas;
        this.jarak = jarak;
        this.urlvideo = urlvideo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrlVideo() {
        return urlvideo;
    }

    public void setUrlVideo(String urlvideo) {
        this.urlvideo = urlvideo;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getJarak() {
        return jarak;
    }

    public void setJarak(String jarak) {
        this.jarak = jarak;
    }
}
