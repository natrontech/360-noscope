from dataclasses import dataclass
from typing import List, Dict

@dataclass
class LayerAttributes:
    wmsUrlResource: str
    scaleLimit: str
    inspireUpperAbstract: str
    inspireName: str
    urlDetails: str
    abstract: str
    inspireAbstract: str
    dataOwner: str
    wmsContactAbbreviation: str
    maps: str
    wmsContactName: str
    dataStatus: str
    inspireUpperName: str
    urlApplication: str

@dataclass
class Layer:
    name: str
    fullName: str
    idGeoCat: str
    layerBodId: str
    attributes: LayerAttributes

@dataclass
class Origin:
    y: int
    x: int
    spatialReference: Dict[str, int]

@dataclass
class Lod:
    height: int
    width: int
    scale: float
    resolution: float
    level: int

@dataclass
class TileInfo:
    origin: Origin
    rows: int
    format: str
    lods: List[Lod]
    spatialReference: Dict[str, int]
    cols: int
    dpi: int
    compressionQuality: str

@dataclass
class Extent:
    xmin: int
    ymin: int
    ymax: int
    xmax: int
    spatialReference: Dict[str, int]

@dataclass
class MapServer:
    mapName: str
    layers: List[Layer]
    tileInfo: TileInfo
    description: str
    fullExtent: Extent
    units: str
    initialExtent: Extent
    spatialReference: Dict[str, int]
    capabilities: str
    copyrightUnicode: str

@dataclass
class Geometry:
    rings: List[List[List[float]]]

@dataclass
class Result:
    featureId: int
    bbox: List[float]
    layerBodId: str
    layerName: str
    id: int
    geometry: Geometry
    attributes: Dict[str, any]

@dataclass
class Data:
    results: List[Result]

@dataclass
class FieldValue:
    name: str
    type: str
    alias: str
    values: List[str]

@dataclass
class DataEntry:
    id: int
    name: str
    fields: List[FieldValue]