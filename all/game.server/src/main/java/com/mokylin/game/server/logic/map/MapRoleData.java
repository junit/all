package com.mokylin.game.server.logic.map;

import com.mokylin.game.server.proto.MapProto;
import com.mokylin.game.server.proto.MapProto.MapData;
import com.mokylin.game.server.proto.MapProto.MapData.Builder;

public class MapRoleData {
	private int model;
	private Coordinate coordinate = new Coordinate();
	private transient int line;

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public MapData toProto() {
		Builder builder = MapProto.MapData.newBuilder();
		builder.setModel(getModel());
		builder.setCoordinate(getCoordinate().toProto());
		return builder.build();
	}

	public void init(MapData map) {
		this.model = map.getModel();
		coordinate.init(map.getCoordinate());
	}
}
