package codegym.module4.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "movie")
@JsonIgnoreProperties("movie_schedules")
@NamedStoredProcedureQuery(name = "GetMovieByMovieScheduleId",
        procedureName = "GetMovieByMovieScheduleId",
        resultClasses = {Movie.class},
        parameters = {@StoredProcedureParameter(name = "movieScheduleId",
                type = Integer.class,
                mode = ParameterMode.IN)}
)
public class Movie
{
    public Movie()
    {
        // Do nothing because of X and Y
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "movie_name")
    @NotEmpty(message = "Tên không được để trống")
    private String movieName;

    @Column(name = "movie_type")
    @NotEmpty(message = "Thể loại phim không được để trống")
    private String movieType;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Temporal(value = TemporalType.DATE)

    @Column(name = "date_start")
    @NotNull(message = "Ngày bắt đầu không được để trống")
    private Date dateStart;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Temporal(value = TemporalType.DATE)
    @Column(name = "date_end")
    @NotNull(message = "Ngày kthúc không được để trống")
    private Date dateEnd;

    @Column(name = "movie_studio")
    @NotEmpty(message = "Hãng phim không được để trống")
    private String movieStudio;

    @Column(name = "directors")
    @NotEmpty(message = "Tác giả không được để trống")
    private String directors;

    @Column(name = "actor")
    @NotEmpty(message = "Diễn viên không được để trống")
    private String actor;

    @Column(name = "duration")
    @NotNull(message = "Thời lượng phim không được để trống")
    @Min(value = 50,message = "Thòi lượng phim phải lớn hơn 50 phút")
      private int duration;

    @Column(name = "content")
    @NotEmpty(message = "Nội dung phim không được để trống")
    private String content;

    @Column(name = "srcImg")
    @NotEmpty(message = "Hình ảnh không được để trống")
    private String srcImg;

    @Column(name = "srcVideo")
    @NotEmpty(message = "Trailer phim không được để trống")
    private String srcVideo;


    @OneToMany(targetEntity = MovieSchedules.class,mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonBackReference

    private List<MovieSchedules> movieSchedules;

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the movieName
     */
    public String getMovieName()
    {
        return movieName;
    }

    /**
     * @param movieName the movieName to set
     */
    public void setMovieName(String movieName)
    {
        this.movieName = movieName;
    }

    /**
     * @return the movieType
     */
    public String getMovieType()
    {
        return movieType;
    }

    /**
     * @param movieType the movieType to set
     */
    public void setMovieType(String movieType)
    {
        this.movieType = movieType;
    }

    /**
     * @return the dateStart
     */
    public Date getDateStart()
    {
        return dateStart;
    }

    /**
     * @param dateStart the dateStart to set
     */
    public void setDateStart(Date dateStart)
    {
        this.dateStart = dateStart;
    }

    /**
     * @return the dateEnd
     */
    public Date getDateEnd()
    {
        return dateEnd;
    }

    /**
     * @param dateEnd the dateEnd to set
     */
    public void setDateEnd(Date dateEnd)
    {
        this.dateEnd = dateEnd;
    }

    /**
     * @return the movieStudio
     */
    public String getMovieStudio()
    {
        return movieStudio;
    }

    /**
     * @param movieStudio the movieStudio to set
     */
    public void setMovieStudio(String movieStudio)
    {
        this.movieStudio = movieStudio;
    }

    /**
     * @return the directors
     */
    public String getDirectors()
    {
        return directors;
    }

    /**
     * @param directors the directors to set
     */
    public void setDirectors(String directors)
    {
        this.directors = directors;
    }

    /**
     * @return the actor
     */
    public String getActor()
    {
        return actor;
    }

    /**
     * @param actor the actor to set
     */
    public void setActor(String actor)
    {
        this.actor = actor;
    }

    /**
     * @return the duration
     */
    public int getDuration()
    {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    /**
     * @return the content
     */
    public String getContent()
    {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content)
    {
        this.content = content;
    }

    /**
     * @return the srcImg
     */
    public String getSrcImg()
    {
        return srcImg;
    }

    /**
     * @param srcImg the srcImg to set
     */
    public void setSrcImg(String srcImg)
    {
        this.srcImg = srcImg;
    }

    /**
     * @return the srcVideo
     */
    public String getSrcVideo()
    {
        return srcVideo;
    }

    /**
     * @param srcVideo the srcVideo to set
     */
    public void setSrcVideo(String srcVideo)
    {
        this.srcVideo = srcVideo;
    }

    /**
     * @return the movieSchedules
     */
    public List<MovieSchedules> getMovieSchedules()
    {
        return movieSchedules;
    }

    /**
     * @param movieSchedules the movieSchedules to set
     */
    public void setMovieSchedules(List<MovieSchedules> movieSchedules)
    {
        this.movieSchedules = movieSchedules;
    }

}
