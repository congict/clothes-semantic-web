package code;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class Image {

    private StreamedContent myImage;

    public Image() {
        InputStream inputStream = null;
        myImage = new DefaultStreamedContent(inputStream, "image/png");
    }

    public StreamedContent getMyImage() {
        return myImage;
    }

    public void setMyImage(StreamedContent myImage) {
        this.myImage = myImage;
    }
}
