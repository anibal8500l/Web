/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportclub.innovativemind;

import com.sportclub.innovativemind.models.Court;
import com.sportclub.innovativemind.models.CourtsEntity;
import com.sportclub.innovativemind.models.Event;
import com.sportclub.innovativemind.models.EventScore;
import com.sportclub.innovativemind.models.EventScoresEntity;
import com.sportclub.innovativemind.models.EventsEntity;
import com.sportclub.innovativemind.models.SportCenter;
import com.sportclub.innovativemind.models.SportCentersEntity;
import com.sportclub.innovativemind.models.Team;
import com.sportclub.innovativemind.models.TeamPlayer;
import com.sportclub.innovativemind.models.TeamPlayersEntity;
import com.sportclub.innovativemind.models.TeamsEntity;
import com.sportclub.innovativemind.models.User;
import com.sportclub.innovativemind.models.UsersEntity;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Usuario on 19/10/2016.
 */
public class SpService implements Serializable {

    private Connection connection;
    private UsersEntity usersEntity;
    private EventsEntity eventsEntity;
    private TeamsEntity teamsEntity;
    private SportCentersEntity sportCentersEntity;
    private CourtsEntity courtsEntity;
    private EventScoresEntity eventScoresEntity;
    private TeamPlayersEntity teamPlayersEntity;

    public SpService() {
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("jdbc/MySQLSportClub");
            connection = dataSource.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public UsersEntity getUsersEntity() {
        if (usersEntity == null) {
            usersEntity = new UsersEntity();
            usersEntity.setConnection(connection);
        }

        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    public EventsEntity getEventsEntity() {
        if (eventsEntity == null) {
            eventsEntity = new EventsEntity();
            eventsEntity.setConnection(connection);
        }
        return eventsEntity;
    }

    public void setEventsEntity(EventsEntity eventsEntity) {
        this.eventsEntity = eventsEntity;
    }

    public TeamsEntity getTeamsEntity() {
        if (teamsEntity == null) {
            teamsEntity = new TeamsEntity();
            teamsEntity.setConnection(connection);
        }
        return teamsEntity;
    }

    public void setTeamsEntity(TeamsEntity teamsEntity) {

        this.teamsEntity = teamsEntity;
    }

    public SportCentersEntity getSportCentersEntity() {
        if (sportCentersEntity == null) {
            sportCentersEntity = new SportCentersEntity();
            sportCentersEntity.setConnection(connection);
        }
        return sportCentersEntity;
    }

    public void setSportCentersEntity(SportCentersEntity sportCentersEntity) {
        this.sportCentersEntity = sportCentersEntity;
    }

    public CourtsEntity getCourtsEntity() {
        if (courtsEntity == null) {
            courtsEntity = new CourtsEntity();
            courtsEntity.setConnection(connection);
        }
        return courtsEntity;
    }

    public void setCourtsEntity(CourtsEntity courtsEntity) {
        this.courtsEntity = courtsEntity;
    }

    public EventScoresEntity getEventScoresEntity() {
        if (eventScoresEntity == null) {
            eventScoresEntity = new EventScoresEntity();
            eventScoresEntity.setConnection(connection);
        }
        return eventScoresEntity;
    }

    public void setEventScoresEntity(EventScoresEntity eventScoresEntity) {
        this.eventScoresEntity = eventScoresEntity;
    }

    public TeamPlayersEntity getTeamPlayersEntity() {
        if(teamPlayersEntity == null){
            teamPlayersEntity = new TeamPlayersEntity();
            teamPlayersEntity.setConnection(connection);
        }
        return teamPlayersEntity;
    }

    public void setTeamPlayersEntity(TeamPlayersEntity teamPlayersEntity) {
        this.teamPlayersEntity = teamPlayersEntity;
    }
    
    
    

    /**
     * metodos de retorno de listas
     *
     * @return
     */
    public List<User> getUsers() {
        if (connection != null) {
            return getUsersEntity().findAll();
        }
        return null;
    }

    public List<Event> getEvents() {
        if (connection != null) {
            return getEventsEntity().findAll();
        }
        return null;
    }

    public List<Team> getTeams() {
        if (connection != null) {
            return getTeamsEntity().findAll();
        }
        return null;
    }

    public List<SportCenter> getSportCenters() {
        if (connection != null) {
            return getSportCentersEntity().findAll();
        }
        return null;
    }

    public List<Court> getCourts() {
        if (connection != null) {
            return getCourtsEntity().findAll();
        }
        return null;
    }

    public List<EventScore> getEventScores() {
        if (connection != null) {
            return getEventScoresEntity().findAll();
        }
        return null;
    }
    
    public List<TeamPlayer> getTeamPlayers(){
        if(connection != null){
            return getTeamPlayersEntity().findAll();
        }
        return null;
    }
    

    /**
     * metodos de retorno de objetos
     *
     * @param id
     * @return
     */
    public User getUser(int id) {
        if (getConnection() != null) {
            return getUsersEntity().findById(id);
        }
        return null;
    }

    public Event getEvent(int id) {
        if (getConnection() != null) {
            Event eventReturn = getEventsEntity().findById(id);
            int courtId= eventReturn.getCourtId().getId();
            eventReturn.setCourtId(getCourt(courtId));
            int sportCenterId = eventReturn.getCourtId().getSportCenterId().getId();
            eventReturn.getCourtId().setSportCenterId(getSportCenter(sportCenterId));
            return eventReturn;
        }
        return null;
    }

    public Team getTeam(int id) {
        if (getConnection() != null) {
            return getTeamsEntity().findById(id);
        }
        return null;
    }

    public SportCenter getSportCenter(int id) {
        if (getConnection() != null) {
            return getSportCentersEntity().findById(id);
        }
        return null;
    }

    public Court getCourt(int id) {
        if (getConnection() != null) {
            return getCourtsEntity().findById(id);
        }
        return null;
    }

    public EventScore getEventScore(int id) {
        if (getConnection() != null) {
            return getEventScoresEntity().findById(id);
        }
        return null;
    }
    public TeamPlayer getTeamPlayer(int id){
        if(getConnection() != null){
            return getTeamPlayersEntity().findById(id);
        }
        return null;
    }

    /**
     * metodos UPDATE
     *
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        return updateUser(
                user.getId(),
                user.getEmail(),
                user.getUserName(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole()
        );
    }

    public boolean updateUser(
            int id,
            String email,
            String userName,
            String password,
            String firstName,
            String lastName,
            String role
    ) {
        if (getConnection() != null) {
            return getUsersEntity().update(
                    id,
                    email,
                    userName,
                    null,
                    firstName,
                    lastName,
                    role
            );
        } else {
            return false;
        }
    }

    public boolean updateEvent(Event event) {
        return updateEvent(
                event.getId(),
                event.getDateIn(),
                event.getDateOut(),
                event.getDescription(),
                event.getTeam1Id(),
                event.getTeam2Id(),
                event.getUserCreatorId(),
                event.getCourtId()
        );
    }

    public boolean updateEvent(
            int id,
            Date dateIn,
            Date dateOut,
            String description,
            Team team1Id,
            Team team2Id,
            User userCreatorId,
            Court courtId
    ) {
        if (getConnection() != null) {
            return getEventsEntity().update(
                    id,
                    dateIn,
                    dateOut,
                    description,
                    team1Id,
                    team2Id,
                    userCreatorId,
                    courtId
            );
        } else {
            return false;
        }
    }

    public boolean updateTeam(Team team) {
        return updateTeam(
                team.getId(),
                team.getName()
        );
    }

    public boolean updateTeam(
            int id,
            String name) {
        if (getConnection() != null) {
            return getTeamsEntity().update(
                    id,
                    name
            );
        } else {
            return false;
        }

    }

    public boolean updateSportCenter(SportCenter sportCenter) {
        return updateSportCenter(
                sportCenter.getId(),
                sportCenter.getName(),
                sportCenter.getAddress(),
                sportCenter.getPhone(),
                sportCenter.getImage(),
                sportCenter.getDescription(),
                sportCenter.getUserId());
    }

    public boolean updateSportCenter(
            int id,
            String name,
            String address,
            String phone,
            String image,
            String description,
            User userId
    ) {
        if (getConnection() != null) {
            return getSportCentersEntity().update(
                    id,
                    name,
                    address,
                    phone,
                    image,
                    description,
                    userId);
        } else {
            return false;
        }
    }

    public boolean updateCourt(Court court) {
        return updateCourt(
                court.getId(),
                court.getType(),
                court.getImage(),
                court.getPrice(),
                court.getScore(),
                court.getSportCenterId()
        );
    }

    public boolean updateCourt(
            int id,
            String type,
            String image,
            float price,
            int score,
            SportCenter sportCenterId
    ) {
        if (getConnection() != null) {
            return getCourtsEntity().update(
                    id,
                    type,
                    image,
                    price,
                    score,
                    sportCenterId
            );
        } else {
            return false;
        }
    }

    public boolean udpateEventScore(EventScore eventScore) {
        return udpateEventScore(
                eventScore.getId(),
                eventScore.getScoreTeam1(),
                eventScore.getScoreTeam2()
        );
    }

    public boolean udpateEventScore(
            int id,
            int scoreTeam1,
            int scoreTeam2
    ) {
        if (getConnection() != null) {
            return getEventScoresEntity().update(
                    id,
                    scoreTeam1,
                    scoreTeam2
            );
        } else {
            return false;
        }

    }
    
    
    public boolean updateTeamPlayer(TeamPlayer teamPlayer){
        return updateTeamPlayer(
                teamPlayer.getId(),
                teamPlayer.getTeamId(),
                teamPlayer.getUserId()
        );
    }
    
    public boolean updateTeamPlayer(
            int id,
            Team teamId,
            User userId
    ){
        if(getConnection()!=null){
            return getTeamPlayersEntity().update(
                    id,
                    teamId,
                    userId
            );
        } else{
            return false;
        }
    }

    /**
     * metodos ADD
     *
     * @param user
     * @return
     */
    public boolean addUser(User user) {
        return addUser(
                user.getId(),
                user.getEmail(),
                user.getUserName(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole()
        );
    }

    public boolean addUser(
            int id,
            String email,
            String userName,
            String password,
            String firstName,
            String lastName,
            String type
    ) {
        if (getConnection() != null) {
            return getUsersEntity().add(
                    id,
                    email,
                    userName,
                    password,
                    firstName,
                    lastName,
                    type
            );
        } else {
            return false;
        }
    }

    public boolean addEvent(Event event) {
        return addEvent(
                event.getId(),
                event.getDateIn(),
                event.getDateOut(),
                event.getDescription(),
                event.getTeam1Id(),
                event.getTeam2Id(),
                event.getUserCreatorId(),
                event.getCourtId()
        );
    }

    public boolean addEvent(
            int id,
            Date dateIn,
            Date dateOut,
            String description,
            Team team1Id,
            Team team2Id,
            User userCreatorId,
            Court courtId
    ) {
        if (getConnection() != null) {
            return (getEventsEntity().add(
                    id,
                    dateIn,
                    dateOut,
                    description,
                    team1Id,
                    team2Id,
                    userCreatorId,
                    courtId
            ));
        } else {
            return false;
        }
    }

    public boolean addTeam(Team team) {
        return addTeam(
                team.getId(),
                team.getName()
        );
    }

    public boolean addTeam(
            int id,
            String name
    ) {
        if (getConnection() != null) {
            return getTeamsEntity().add(
                    id,
                    name
            );
        } else {
            return false;
        }
    }

    public boolean addSportCenter(SportCenter sportCenter) {
        return addSportcenter(
                sportCenter.getId(),
                sportCenter.getName(),
                sportCenter.getAddress(),
                sportCenter.getPhone(),
                sportCenter.getImage(),
                sportCenter.getDescription(),
                sportCenter.getUserId()
        );
    }

    public boolean addSportcenter(
            int id,
            String name,
            String address,
            String phone,
            String image,
            String description,
            User userId
    ) {
        if (getConnection() != null) {
            return (getSportCentersEntity().add(
                    id,
                    name,
                    address,
                    phone,
                    image,
                    description,
                    userId
            ));
        } else {
            return false;
        }
    }

    public boolean addCourt(Court court) {
        return addCourt(
                court.getId(),
                court.getType(),
                court.getImage(),
                court.getPrice(),
                court.getScore(),
                court.getSportCenterId()
        );
    }

    public boolean addCourt(
            int id,
            String type,
            String image,
            float price,
            int score,
            SportCenter sportCenterId
    ) {
        if (getConnection() != null) {
            return getCourtsEntity().add(
                    id,
                    type,
                    image,
                    price,
                    score,
                    sportCenterId
            );
        } else {
            return false;
        }
    }

    public boolean addEventScore(EventScore eventScore) {
        return addEventScore(
                eventScore.getId(),
                eventScore.getScoreTeam1(),
                eventScore.getScoreTeam2()
        );
    }

    public boolean addEventScore(
            int id,
            int scoreTeam1,
            int scoreTeam2
    ) {
        if (getConnection() != null) {
            return getEventScoresEntity().add(
                    id,
                    scoreTeam1,
                    scoreTeam2
            );
        } else {
            return false;
        }
    }

    public boolean addTeamPlayer(TeamPlayer teamPlayer){
        return addTeamPlayer(
                teamPlayer.getId(),
                teamPlayer.getTeamId(),
                teamPlayer.getUserId()
        );
    }
    
    public boolean addTeamPlayer(
            int id,
            Team teamId,
            User userId
    ){
        if(getConnection()!=  null){
            return getTeamPlayersEntity().add(
                    id,
                    teamId,
                    userId
            );
        } else {
            return false;
        }
    }
    /**
     * metodos DELETE
     *
     * @param id
     * @return
     */

    public boolean deleteUser(int id) {
        if (getConnection() != null) {
            return (getUsersEntity().delete(id));
        } else {
            return false;
        }
    }

    public boolean deleteEvent(int id) {
        if (getConnection() != null) {
            return (getEventsEntity().delete(id));
        } else {
            return false;
        }
    }

    public boolean deleteTeam(int id) {
        if (getConnection() != null) {
            return getTeamsEntity().delete(id);
        } else {
            return false;
        }
    }

    public boolean deleteSportCenter(int id) {
        if (getConnection() != null) {
            return getSportCentersEntity().delete(id);
        } else {
            return false;
        }
    }

    public boolean deleteCourt(int id) {
        if (getConnection() != null) {
            return getCourtsEntity().delete(id);
        } else {
            return false;
        }
    }

    public boolean deleteEventScore(int id) {
        if (getConnection() != null) {
            return getEventScoresEntity().delete(id);
        } else {
            return false;
        }
    }
    
    public boolean deleteTeamPlayer(int id){
        if(getConnection()!= null){
            return getTeamPlayersEntity().delete(id);
        } else {
            return false;
        }
    }
}
