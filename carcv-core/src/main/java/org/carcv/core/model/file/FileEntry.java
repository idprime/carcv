/**
 * 
 */
package org.carcv.core.model.file;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.carcv.core.model.CarData;
import org.carcv.core.model.AbstractEntry;

/**
 * @author oskopek
 * 
 */
@Entity
public class FileEntry extends AbstractEntry {

    /**
     * 
     */
    private static final long serialVersionUID = -8030471101247536237L;

    private List<FileCarImage> carImages;
    private CarData carData;

    @SuppressWarnings("unused")
    private FileEntry() {
        //intentionally empty
    }

    /**
     * @param carData
     * @param carImages
     */
    public FileEntry(CarData carData, List<FileCarImage> carImages) {
        this.carData = carData;
        this.carImages = carImages;
    }

    @Override
    @NotNull
    @Embedded
    public CarData getCarData() {
        return carData;
    }

    @Override
    @NotNull
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, targetEntity=FileCarImage.class)
    public List<FileCarImage> getCarImages() {
        return carImages;
    }

    /**
     * @param carImage
     *            the carImage to set
     */
    public void setCarImages(List<FileCarImage> carImages) {
        this.carImages = carImages;
    }

    /**
     * @param carData
     *            the carData to set
     */
    public void setCarData(CarData carData) {
        this.carData = carData;
    }

    @Override
    public String toString() {
        return "FileEntry[id=" + getId() + ", carImages.size()=" + carImages.size() + ", carData=" + carData.toString()
                + "]";
    }

}