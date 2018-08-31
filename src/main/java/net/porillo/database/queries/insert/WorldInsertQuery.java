package net.porillo.database.queries.insert;

import net.porillo.database.api.InsertQuery;
import net.porillo.objects.GWorld;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorldInsertQuery extends InsertQuery {

	private GWorld world;

	public WorldInsertQuery(GWorld world) {
		super("worlds");
		this.world = world;
	}

	@Override
	public String getSQL() {
		return "INSERT INTO worlds (uniqueID, worldName, firstSeen, carbonValue, seaLevel, size)" +
				" VALUES (?,?,?,?,?,?)";
	}

	@Override
	public PreparedStatement prepareStatement(Connection connection) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(getSQL());
		preparedStatement.setLong(1, world.getUniqueID());
		preparedStatement.setString(2, world.getWorldName());
		preparedStatement.setLong(3, world.getFirstSeen());
		preparedStatement.setInt(4, world.getCarbonValue());
		preparedStatement.setInt(5, world.getSeaLevel());
		preparedStatement.setInt(6, world.getSize());
		return preparedStatement;
	}

	@Override
	public Long getUniqueID() {
		return world.getUniqueID();
	}
}
